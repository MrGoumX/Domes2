import java.util.Comparator;

public class MaxPQ<T> implements MaxPQInt<T>{
    private T[] heap;
    private int size;
    protected Comparator<T> cmp;

    public MaxPQ(int cap, Comparator<T> cmp){
        if(cap < 1) throw new IllegalArgumentException();
        this.heap = (T[]) new Object[cap+1];
        this.size = 0;
        this.cmp = cmp;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void insert(T object){
        if(object==null) throw new IllegalArgumentException();
        if(size == heap.length-1) throw new IllegalStateException();
        heap[++size] = object;
        swim(size);
    }

    @Override
    public T removeMin(){
        if(size==0) throw new IllegalStateException();
        T object = heap[1];
        if(size > 1) heap[1] = heap[size];
        heap[size--] = null;
        sink(1);
        return object;
    }

    @Override
    public T getMin(){
        if(size==0) throw new IllegalStateException();
        T min = heap[1];
        sink(1);
        return min;
    }

    public T getMax(){
        if(size==0) throw new IllegalStateException();
        return heap[size];
    }

    private void swim(int i){
        while(i > 1){
            if(cmp.compare(heap[i/2], heap[i])>0) swap(i, i/2);
            i = i/2;
        }
    }

    private void sink(int i){
        while(2*i <= size){
            int j = 2*i;
            if(j < size && (cmp.compare(heap[j], heap[j+1])>0)) j++;
            if(!(cmp.compare(heap[i], heap[j])>0)) break;
            swap(i, j);
            i = j;
        }
    }

    private void swap(int i, int j){
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @Override
    public void print(){
        for(int i=1; i <= size; i++){
            System.out.println(heap[i]);
        }
    }

    @Override
    public int getSize(){
        return size;
    }
}
