import java.util.Comparator;

public class MaxPQ implements MaxPQInt{
    private Processor[] heap;
    private int size;

    public MaxPQ(int cap){
        if(cap < 1) throw new IllegalArgumentException();
        this.heap = new Processor[cap+1];
        this.size = 0;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void insert(Processor object){
        if(object==null) throw new IllegalArgumentException();
        if(size == heap.length-1) throw new IllegalStateException();
        heap[++size] = object;
        swim(size);
    }

    @Override
    public Processor removeMax(){
        if(size==0) throw new IllegalStateException();
        Processor object = heap[1];
        if(size > 1) heap[1] = heap[size];
        heap[size--] = null;
        sink(1);
        return object;
    }

    @Override
    public Processor getMax(){
        if(size==0) throw new IllegalStateException();
        Processor min = heap[1];
        return min;
    }

    private void swim(int i){
        while(i > 1){
            if(heap[i/2].compareTo(heap[i])>0) swap(i, i/2);
            i = i/2;
        }
    }

    private void sink(int i){
        while(2*i <= size){
            int j = 2*i;
            if(j < size && (heap[j].compareTo(heap[j+1])>0)) j++;
            if(!(heap[i].compareTo(heap[j])>0)) break;
            swap(i, j);
            i = j;
        }
    }

    @Override
    public void addProcess(int ms){
        Processor min = getMax();
        min.getList().addLast(ms);
        sink(1);
    }

    private void swap(int i, int j){
        Processor temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @Override
    public void print(){
        for(int i=1; i <= size; i++){
            System.out.println(heap[i].getActiveTime());
        }
    }

    @Override
    public int getSize(){
        return size;
    }
}
