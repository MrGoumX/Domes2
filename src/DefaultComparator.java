import java.util.Comparator;

//Compares whatever item you give(used in CharQueueWithMinImpl for generics)
final class DefaultComparator<T extends Comparable<? super T>> implements Comparator<T> {
    public int compare(T a, T b) {
        if(a.compareTo(b) < 0){
            return -1;
        }
        else if(a.compareTo(b) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
}
