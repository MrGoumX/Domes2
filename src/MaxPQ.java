import java.util.Comparator;

public class MaxPQ<T extends Comparable<T>>{
    private T[] heap;
    private int size;
    protected Comparator<T> cmp;

    public MaxPQ(int cap, Comparator<T> cmp){
        if(size < 1) throw new IllegalArgumentException();
        this.heap = (T []) new Object[cap+1];
        this.size = 0;
        this.cmp = cmp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(T object){
        if(object==null) throw new IllegalArgumentException();
        if(size == heap.length-1) throw new IllegalStateException();
        heap[+size] = object;
        swim(size);
    }

    public T getMax(){
        if(size==0) throw new IllegalStateException();
        T object = heap[1];
        if(size>1) heap[1] = heap[size];
        heap[size--] = null;
        return object;
    }

    private void swim(int i){
        while(i>1){
            int p = i/2;
            int result = cmp.compare(heap[i], heap[p]);
            if(result <= 0) return;
            swap(i, p);
            i = p;
        }
    }

    private void sink(int i){
        int left = 2*i, right = left + 1, max = left;
        while(left <= size){
            if(right <= size){
                max = cmp.compare(heap[left], heap[right]) < 0 ? right : left;
            }
            if(cmp.compare(heap[i], heap[max]) >= 0) return;
            swap(i, max);
            i = max;
            left = 2*i;
            right = left + 1;
            max = left;
        }
    }

    private void swap(int i, int j){
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void print(){
        for(int i=0; i < size; i++){
            System.out.println(heap[i]);
        }
    }
}
