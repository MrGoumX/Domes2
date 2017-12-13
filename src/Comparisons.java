import java.io.*;
import java.util.Random;

public class Comparisons {
    private static int GreedMakespan, GreedDecMakespan;
    public static void main(String[] args) throws IOException{
        for(int i = 0; i < 10; i++){
            createFiles(100, "src/data/"+100+"_"+i+".txt");
        }
        for(int i = 0; i < 10; i++){
            createFiles(500, "src/data/"+500+"_"+i+".txt");
        }
        for(int i = 0; i < 10; i++){
            createFiles(1000, "src/data/"+1000+"_"+i+".txt");
        }
        for(int i = 0; i < 10; i++){
            tortureTest("src/data/"+100+"_"+i+".txt");
        }
        int AvGreedMakespan100 = GreedMakespan/100;
        int AvGreedDecMakespan100 = GreedDecMakespan/100;
        GreedMakespan = 0;
        GreedDecMakespan = 0;
        for(int i = 0; i < 10; i++){
            tortureTest("src/data/"+500+"_"+i+".txt");
        }
        int AvGreedMakespan500 = GreedMakespan/500;
        int AvGreedDecMakespan500 = GreedDecMakespan/500;
        GreedMakespan = 0;
        GreedDecMakespan = 0;
        for(int i = 0; i < 10; i++){
            tortureTest("src/data/"+1000+"_"+i+".txt");
        }
        int AvGreedMakespan1000 = GreedMakespan/1000;
        int AvGreedDecMakespan1000 = GreedDecMakespan/1000;
        GreedMakespan = 0;
        GreedDecMakespan = 0;
        printAndSave(AvGreedMakespan100, AvGreedDecMakespan100, AvGreedMakespan500, AvGreedDecMakespan500, AvGreedMakespan1000, AvGreedDecMakespan1000);
    }

    private static void createFiles(int n, String name) throws IOException{
        Random ran = new Random();
        Writer writer = new OutputStreamWriter(new FileOutputStream(name), "UTF-8");
        writer.write((int)Math.round(Math.sqrt(n)) + "\n");
        writer.write(n + "\n");
        for(int i = 0; i < n; i++){
            writer.write((ran.nextInt(1000000)) + "\n");
        }
        writer.flush();
        writer.close();
    }

    private static void tortureTest(String filename){
        Greedy(filename);
        GreedyDec(filename);
    }

    private static void Greedy(String filename){
        BufferedReader data = null;
        MaxPQ<Processor> pcs = null;
        int nop = 0, nops = 0, makespan = 0;
        try{
            data = new BufferedReader(new FileReader(filename));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(data != null){
            try{
                nop = Integer.parseInt(data.readLine());
            }catch(IOException e){
                System.err.println("Not a number");
            }
            pcs = new MaxPQ<Processor>(nop, new DefaultComparator<Processor>());
            for(int i = 0; i < nop; i++){
                pcs.insert(new Processor());
            }
            try{
                nops = Integer.parseInt(data.readLine());
            }
            catch(IOException e) {
                System.err.println("Not a number");
            }
            for(int i = 0; i < nops; i++){
                try{
                    int span = Integer.parseInt(data.readLine());
                    pcs.getMin().getList().addLast(span);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0; i < nop; i++) {
            Processor temp = pcs.removeMin();
            if(temp.getActiveTime()>makespan) makespan = temp.getActiveTime();
        }
        GreedMakespan += makespan;
    }

    private static void GreedyDec(String filename){
        BufferedReader data = null;
        MaxPQ<Processor> pcs = null;
        Integer procs[];
        int nop = 0, nops = 0, makespan = 0;
        try{
            data = new BufferedReader(new FileReader(filename));
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
                pcs.getMin().getList().addLast(procs[i]);
            }
            for (int i = 0; i < nop; i++) {
                Processor temp = pcs.removeMin();
                if(temp.getActiveTime()>makespan) makespan = temp.getActiveTime();
            }
            GreedDecMakespan += makespan;
        }
    }

    private static void printAndSave(int AvGreedMakespan100,int AvGreedDecMakespan100,int AvGreedMakespan500,int AvGreedDecMakespan500,int AvGreedMakespan1000,int AvGreedDecMakespan1000) throws IOException{
        System.out.println("The average greedy makespan with 100 processes is: " + AvGreedMakespan100);
        System.out.println("The average greedy decreasing makespan with 100 processes is: " + AvGreedDecMakespan100);
        System.out.println("The average greedy makespan with 500 processes is: " + AvGreedMakespan500);
        System.out.println("The average greedy decreasing makespan with 100 processes is: " + AvGreedDecMakespan500);
        System.out.println("The average greedy makespan with 1000 processes is: " + AvGreedMakespan1000);
        System.out.println("The average greedy decreasing makespan with 1000 processes is: " + AvGreedDecMakespan1000);
        Writer writer = new OutputStreamWriter(new FileOutputStream("src/data/Comparisons.txt"), "UTF-8");
        writer.write("The average greedy makespan with 100 processes is: " + AvGreedMakespan100 +"\n");
        writer.write("The average greedy decreasing makespan with 100 processes is: " + AvGreedDecMakespan100 +"\n");
        writer.write("The average greedy makespan with 500 processes is: " + AvGreedMakespan500 +"\n");
        writer.write("The average greedy decreasing makespan with 100 processes is: " + AvGreedDecMakespan500 +"\n");
        writer.write("The average greedy makespan with 1000 processes is: " + AvGreedMakespan1000 +"\n");
        writer.write("The average greedy decreasing makespan with 1000 processes is: " + AvGreedDecMakespan1000 +"\n");
        writer.flush();
        writer.close();
    }
}
