import java.util.*;

public class EpamInterview {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

    //Input: [[6,10],[15,18],[1,3],[2,6]]
    //Output: [[1,10],[15,18]]

        /*
            [1,2],[2,10]

         */

        int[][] input = new int[][]{
                {1,10}
        };
        int[][] res=processPairs(input);
        print(res);

     }

     static void print(int[][] arr){
        for(int i=0;i<arr.length;i++){

            for(int v:arr[i]){
                System.out.print(v+",");
            }
            System.out.println();
        }
     }

    private static int[][] processPairs(int[][] pairs){
          Arrays.sort(pairs ,(a,b)->{
           return a[0]-b[0];
          });

          List<int[]> list= new LinkedList<>();
          if(pairs.length ==0){
              return new int[1][0];
          }
          int[] prev = pairs[0];
          for(int i=1;i<pairs.length;i++){
              int[] cur= pairs[i];
              if(isOverlap(prev,cur)){
                  prev[0] = Math.min(prev[0],cur[0]);
                  prev[1] = Math.max(prev[1],cur[1]);
              }else{
                  list.add(prev);
                  prev = cur;
              }
          }
          list.add(prev);
          int size= list.size();
          int[][] result = new int[size][2];
          for(int i=0;i<size;i++){
              result[i]=list.get(i);
          }
          return result;
    }
    static  boolean isOverlap(int[] first,int[] second){
        if( first[0]> second[1] || second[0] > first[1]){
            return false;
        }
        return true;
    }
}
