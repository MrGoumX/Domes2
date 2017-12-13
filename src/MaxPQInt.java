public interface MaxPQInt<T> {

    /**
     * @return true if the priority queue is empty
     */
    public boolean isEmpty();

    /**
     * insert an object in the priority queue
     * @param object
     */
    public void insert(T object);

    /**
     * removes and returns the minimum item from the priority queue
     * @return minimum object
     */
    public T removeMin();

    /**
     * returns the minimum item from the priority queue
     * @return minimum object
     */
    public T getMin();

    public void swim(int i);

    public void sink(int i);

    public void swap(int i, int j);

    /**
     * prints the priority queue
     */
    public void print();

    /**
     * returns the size of the priority queue
     * @return size
     */
    public int getSize();
}
