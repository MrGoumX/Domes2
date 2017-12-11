import java.io.PrintStream;
import java.util.NoSuchElementException;

public class List<T> implements ListInt<T> {
    private ListNode<T> first, last;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void addFirst(T item) {
        ListNode<T> temp = new ListNode<T>(item);
        if (isEmpty()) {
            first = last = temp;
            first.next = null;
        } else {
            temp.next = first;
            first = temp;
        }
        size++;
    }

    @Override
    public T removeFirst() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        T removed = first.getData();
        if (first == last) {
            first = last = null;
        } else {
            first = first.next;
        }
        size--;
        return removed;
    }

    @Override
    public void addLast(T item) {
        ListNode<T> temp = new ListNode<T>(item);
        if (isEmpty()) {
            first = last = temp;
            temp.next = null;
        } else {
            last.next = temp;
            last = temp;
        }
        size++;
    }

    @Override
    public T removeLast() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        T removed = last.getData();
        if (first == last) {
            first=last=null;
        } else {
            last.next = null;
        }
        size--;
        return removed;
    }

    @Override
    public ListNode<T> getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return first;
    }

    @Override
    public T getFirstElement(){
        if (isEmpty()) throw new NoSuchElementException();
        return first.getData();
    }

    @Override
    public ListNode<T> getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return last;
    }

    @Override
    public T getLastElement(){
        if (isEmpty()) throw new NoSuchElementException();
        return last.getData();
    }

    @Override
    public void printList(PrintStream stream) {
        if (isEmpty()) {
            System.out.printf("The List is empty\n");
            return;
        }
        ListNode<T> temp = first;
        while(temp != null) {
            System.out.printf("%s ", temp.getData());
            temp = temp.getNext();
        }
        System.out.printf("\n");
    }

    @Override
    public String toString(){
        if(isEmpty()) return null;
        ListNode<T> temp = first;
        String ret = "";
        while(temp!=null){
            ret += temp.getData() + " ";
            temp = temp.getNext();
        }
        return ret;
    }

    @Override
    public int size() {
        return size;
    }
}
