import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class AirtelInterview2023 {


    /*
     Rate Limit

     func(String id,
     threashold=
     window in sec ,
     sec : 60
     number of requ
     nor:5

     500, 559, 5

     559 : denied

     id,


        */
    public static void main(String[] args) throws  Exception{
          AirtelInterview2023 airtelInterview2023=new AirtelInterview2023();
// 1687264896848=1, 1687264905856=2, 1687264914857=3, 1687264923857=4, 1687264932858=5, 1687264941859=6
        long diff= 1687264941859l- 1687264896848l;
        System.out.println("diff:"+diff);
          for(int i=0;i<20;i++){
              boolean val=airtelInterview2023.isAllowed("1223");
              System.out.println("i:"+(i+1)+ " res:"+val);
              Thread.sleep(9000L);
          }

    }
    Map<String, TreeMap<Long,Integer>> map=new HashMap<>();
    int allowedRequestCount=5;
    int timeWindowInSec=60;

    Map<String,Integer> counterMap= new HashMap<>();
    boolean isAllowed(String id){
        // current System time
        /*
         curTime=
         prevTime = curTime-60;

         1- 1
         5-2
         6 -3

         60-

         */
        System.out.println(map+ " "+counterMap);
        TreeMap<Long,Integer> countMap= map.getOrDefault(id, new TreeMap<Long,Integer>());
        int counter= counterMap.getOrDefault(id,0);
        long curTime= System.currentTimeMillis();
        long prevTime= curTime - (timeWindowInSec*1000);
        var entryPrev=countMap.floorEntry(prevTime);
        var entryCurCount=countMap.floorEntry(curTime);
        int prevCount=0;
        if(entryPrev != null){
            prevCount=entryPrev.getValue();
        }
        int curCount=0;
        if(entryCurCount != null){
            curCount=entryCurCount.getValue();
        }
        int count = curCount - prevCount;
        System.out.println(" curCount:"+curCount+ " prevCount:"+prevCount);
        if( count >= allowedRequestCount){
            return false;
        }else{
            counter++;
            countMap.put(curTime,counter);
            counterMap.put(id,counter);
        }
        map.put(id,countMap);
        return true;



    }

}
