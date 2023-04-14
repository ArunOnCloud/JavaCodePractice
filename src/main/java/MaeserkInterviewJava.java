import java.util.List;
import java.util.stream.Collectors;

public class MaeserkInterviewJava {


    public static void main(String[] args){

        List<Integer> list= List.of(1200,2020,1999,2010,2002,2004);

        List<Integer> res=list.stream().filter((e)->{
            if( e%4 ==0 && ( e %100 != 0) && (e%400) !=0){
                return true;
            }else  if( e%100 ==0  && e%400==0){
                return true;
            }else{
                return false;
            }

        }).collect(Collectors.toList());
        System.out.println(res);
    }
}




