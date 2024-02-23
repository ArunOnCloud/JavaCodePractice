import java.util.*;

public class TescoInterviewAlgo {

    /*

    Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.


In a store, a colleague can work for multiple departments. Here are shifts of a colleague in various departments:

In Bakery department: From 8 to 10

In Checkout department: From 10 to 12

In Diary department: From 14 to 19

Given the above split of shifts, provide an API/method to return the different shifts of a colleague for the day after merging contiguous shifts. This will be exposed to the colleague in different UI and help them plan their day accordingly.

His shift timings in this case are 8 to 12 and 14 to 19.

shift range:1,24

[[1,2],[3,5],[8,10],[10,12],[13,14]]

[[1,2],[3,5],[8,12],[13,14]]

TC:nlogn
     */

    public static void main(String[] args) {


        TescoInterviewAlgo tescoInterviewAlgo = new TescoInterviewAlgo();
        int[][] shifts= new int[][]{
                {8,10},{10,12},{14,19}
        };

        tescoInterviewAlgo.print(tescoInterviewAlgo.mergeShift(shifts));

    }


    List<int[]> mergeShift(int[][] shifts){
        List<int[]> result= new LinkedList<>();

        int n = shifts.length;
        if( n ==0){
            return new LinkedList<>();
        }else if( n== 1){
            result.add(shifts[0]);
            return result;
        }
        Arrays.sort(shifts,(a,b)->{
            return a[0]-b[0];
        });
        int[] prev= shifts[0];
        for(int i=1;i<n;i++){
            int[] cur= shifts[i];
            if(isMergable(prev,cur)){
                prev[0] = Math.min(prev[0],cur[0]);
                prev[1] = Math.max(prev[1],cur[1]);
            }else{
                result.add(prev);
                prev = cur;
            }
        }
        result.add(prev);
        return result;
    }

    void print(List<int[]> list){
        for( int[] arr:list){
            System.out.print("["+arr[0]+","+arr[1]+"]"+",");
        }
        System.out.println();
    }

    boolean isMergable(int[] prev,int[] cur){

        if( cur[0] > prev[1] || cur[1] <prev[0]){
            return false;
        }
        return true;
    }



}
