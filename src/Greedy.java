import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Greedy {
    public static void main(String[] args){
        BufferedReader data = null;
        int nop = 0, nops = 0;
        try{
            data = new BufferedReader(new FileReader("src/data/data1.txt"));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(data != null){
            try{
                nop = Integer.parseInt(data.readLine());
            }catch(IOException e){
                System.err.println("Not a number");
            }
            for(int i = 0; i < nop; i++){
                new Processor();
            }
            try{
                nops = Integer.parseInt(data.readLine());
            }
            catch(IOException e) {
                System.err.println("Not a number");
            }

        }
    }

    public void add(){

    }
}
