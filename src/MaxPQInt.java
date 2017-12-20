public interface MaxPQInt {

    /**
     * @return true if the priority queue is empty
     */
    public boolean isEmpty();

    /**
     * insert an object in the priority queue
     * @param object
     */
    public void insert(Processor object);

    /**
     * removes and returns the minimum item from the priority queue
     * @return minimum object
     */
    public Processor removeMax();

    /**
     * returns the minimum item from the priority queue
     * @return minimum object
     */
    public Processor getMax();

    /**
     * adds a process into the processor with the maximum priority
     * @param ms
     */
    public void addProcess(int ms);

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
