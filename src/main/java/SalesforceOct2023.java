
import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;



public class SalesforceOct2023 {


    public static void main(String[] args) {
        System.out.println( makeStringWithNoDuplicateAdjacentChars("aab"));
        System.out.println( makeStringWithNoDuplicateAdjacentChars("aaabfgh"));
        System.out.println( makeStringWithNoDuplicateAdjacentChars("aabbb"));

    }

    static String makeStringWithNoDuplicateAdjacentChars(String str){

        Map<Character,Integer> map = new HashMap<>();

        for(char c: str.toCharArray()){
            int count= map.getOrDefault(c, 0);
            map.put(c,count+1);
        }

        PriorityQueue<Pair>  queue = new PriorityQueue<>((a,b)->{

            return b.count - a.count;
        });
        for( Map.Entry<Character,Integer> entry: map.entrySet()){
            queue.add( new Pair(entry.getKey(),entry.getValue()));
        }

        StringBuilder sb= new StringBuilder();
        char prev;
        Pair p = queue.poll();
        sb.append(p.c);
        prev = p.c;
        p.count= p.count-1;
        if(p.count >0){
            queue.add(p);
        }

        while(queue.size()>0){
            Pair pa= queue.poll();
            Pair pb =null;
            if( queue.size()>0){
                pb = queue.poll();
            }
            if( pb == null){
                if( prev == pa.c){
                    return "";
                }else{
                    sb.append(pa.c);
                    prev = pa.c;
                    pa.count--;
                    if( pa.count >0){
                        queue.add(pa);
                    }
                }
            }else{

                if( pa.c != prev){
                    sb.append(pa.c);
                    prev =pa.c;
                    pa.count--;
                    if( pa.count >0){
                        queue.add(pa);
                    }
                    queue.add(pb);
                }else{
                    sb.append(pb.c);
                    prev =pb.c;
                    pb.count--;
                    if( pb.count >0){
                        queue.add(pb);
                    }
                    queue.add(pa);
                }
            }


        }


        return sb.toString();

    }
}
class Pair{
    char c;
    int count;
    Pair(char c,int count){
        this.c= c;
        this.count = count;
    }
}
