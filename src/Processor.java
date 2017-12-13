public class Processor implements Comparable<Processor>{
    private static int processors;
    private int id;
    private List<Integer> processed_jobs = new List<Integer>();

    Processor(){
        id = processors;
        processors++;
    }

    public int getActiveTime(){
        int time = 0;
        if(processed_jobs.isEmpty()){
            time = 0;
        }
        else{
            ListNode<Integer> temp = processed_jobs.getFirst();
            while(temp!=null){
                time += temp.getData();
                temp = temp.getNext();
            }
        }
        return time;
    }

    public List<Integer> getList(){
        return processed_jobs;
    }

    public int getID(){
        return id;
    }

    @Override
    public int compareTo(Processor o) {
        if(getActiveTime() > o.getActiveTime()){
            return 1;
        }
        else if(getActiveTime() < o.getActiveTime()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
