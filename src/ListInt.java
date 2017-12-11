import java.io.PrintStream;
import java.util.NoSuchElementException;

public interface ListInt<T> {

    /**
     * @return true if the list is empty
     */
    public boolean isEmpty();

    /**
     * insert a node at the front of the list
     */
    public void addFirst(T item);

    /**
     * remove and return an object from the front of the list
     * @return object from the front of the list
     * @throws NoSuchElementException if the list is empty
     */
    public T removeFirst() throws NoSuchElementException;

    /**
     * insert an object at the end of the list
     */
    public void addLast(T item);

    /**
     * remove and return an object from the end of the list
     * @return object from the end of the list
     * @throws NoSuchElementException if the list is empty
     */
    public T removeLast() throws NoSuchElementException;

    /**
     * return without removing the first item in the list
     * @return ListNode from the front of the list
     * @throws NoSuchElementException if the list is empty
     */
    public ListNode<T> getFirst();

    /**
     * return without removing the first item in the list
     * @return object from the front of the list
     * @throws NoSuchElementException if the list is empty
     */
    public T getFirstElement();

    /**
     * return without removing the last item in the list
     * @return ListNode from the end of the list
     * @throws NoSuchElementException if the list is empty
     */
    public ListNode<T> getLast();

    /**
     * return without removing the last item in the list
     * @return object from the end of the list
     * @throws NoSuchElementException if the list is empty
     */
    public T getLastElement();

    /**
     * print the elements of the list, starting from the front,
     * to the print stream given as argument. For example, to
     * print the elements to the
     * standard output, pass System.out as parameter. E.g.,
     * printList(System.out);
     */
    public void printList(PrintStream stream);

    /**
     * return the size of the queue, 0 if empty
     * @return number of elements in the list
     */
    public int size();
}
