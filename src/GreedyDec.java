import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GreedyDec {
    public static void main(String[] args){
        BufferedReader data = null;
        MaxPQ<Processor> pcs = null;
        Integer procs[];
        int nop = 0, nops = 0, makespan = 0;
        try{
            data = new BufferedReader(new FileReader("src/data/simple.txt"));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(data != null) {
            try {
                nop = Integer.parseInt(data.readLine());
            } catch (IOException e) {
                System.err.println("Not a number");
            }
            pcs = new MaxPQ<Processor>(nop, new DefaultComparator<Processor>());
            for (int i = 0; i < nop; i++) {
                pcs.insert(new Processor());
            }
            try {
                nops = Integer.parseInt(data.readLine());
            } catch (IOException e) {
                System.err.println("Not a number");
            }
            procs = new Integer[nops];
            for(int i = 0; i < nops; i++){
                try{
                    procs[i] = Integer.parseInt(data.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            Sort<Integer> QC = new Sort<Integer>();
            QC.sort(procs, 0, procs.length-1);
            for(int i = 0; i < procs.length; i++){
                Processor min = pcs.getMin();
                min.getList().addLast(procs[i]);
                pcs.sink(1);
            }
            for (int i = 0; i < nop; i++) {
                Processor temp = pcs.removeMin();
                System.out.println("id " + temp.getID() + ", load=" + temp.getActiveTime() + ": " + temp.getList().toString());
                if(temp.getActiveTime()>makespan) makespan = temp.getActiveTime();
            }
            System.out.println("Makespan = " + makespan);
        }
    }
}
