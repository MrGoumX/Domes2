public class Testing {
    public static void main(String[] args){
        MaxPQ<Integer> test = new MaxPQ<Integer>(5, new DefaultComparator<Integer>());
        test.insert(1);
        test.insert(5);
        test.insert(-1);
        test.insert(100);
        test.insert(-50);
        //test.print();
        //System.out.println(test.getMax());
        System.out.println(test.getMin());
    }
}
