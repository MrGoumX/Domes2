import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Greedy {
    public static void main(String[] args) {
        Greedy();
    }
    public static void Greedy () {
        BufferedReader data = null;
        MaxPQ pcs = null;
        int nop = 0, nops = 0, makespan = 0;
        try {
            data = new BufferedReader(new FileReader("src/data/simple.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (data != null) {
            try {
                nop = Integer.parseInt(data.readLine());
            } catch (IOException e) {
                System.err.println("Not a number");
            }
            pcs = new MaxPQ(nop);
            for (int i = 0; i < nop; i++) {
                pcs.insert(new Processor());
            }
            try {
                nops = Integer.parseInt(data.readLine());
            } catch (IOException e) {
                System.err.println("Not a number");
            }
            for (int i = 0; i < nops; i++) {
                try {
                    int span = Integer.parseInt(data.readLine());
                    pcs.addProcess(span);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0; i < nop; i++) {
            Processor temp = pcs.removeMax();
            System.out.println("id " + temp.getID() + ", load=" + temp.getActiveTime() + ": " + temp.getList().toString());
            if (temp.getActiveTime() > makespan) makespan = temp.getActiveTime();
        }
        System.out.println("Makespan = " + makespan);
    }
}

