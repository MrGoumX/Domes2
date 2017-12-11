public class Sort<T extends Comparable<T>> {
    public void sort(T[] arr, int low, int high){
        int i = low, j = high;
        T pivot = arr[low + (high-low) / 2];
        while(i <= j){
            while(arr[i].compareTo(pivot)>0){
                i++;
            }
            while(arr[j].compareTo(pivot)<0){
                j--;
            }
            if(i<=j){
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if(low<j) sort(arr, low, j);
        if(i<high) sort(arr, i, high);
    }
}
