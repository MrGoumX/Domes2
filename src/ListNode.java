public class ListNode<T> {
    private T data;
    protected ListNode<T> next;

    ListNode( T object ){
        this( object, null );
    }

    ListNode( T object, ListNode<T> node ){
        data = object;
        next = node;
    }

    T getData(){
        return data;
    }

    ListNode<T> getNext(){
        return next;
    }
}
