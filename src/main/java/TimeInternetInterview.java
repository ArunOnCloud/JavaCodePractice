import java.util.ArrayList;
import java.util.List;

public class TimeInternetInterview {


    /*
      arr = [2,3,5,7]
      find gcd of number factorials
      gcd 2!,3!,5!,7!

     2! = 1*2
     5!= 1*2*3*4*5

     smallest : x
     x!
      2,3,5,7

      2,4
     gcd : 2

     4,12
     4


     factorial of large number:
     x!
     output: in string:

     num : >20 digits
     string a,
     string b,
     a*b

     Stirng mult (String a,String b){

     }

     123 i  n
      23 j  m

           n+m
           O(n*m)

     369
    246
---------
      729

     */


//    String multiply(String a,String b){
//        String big=a;
//        String sma=b;
//        if(b.length()> a.length()){
//            big=b;
//            sma=a;
//        }
//        String res="";
//        int carry=0;
//        List<StringBuilder> list= new ArrayList<>();
//
//        for(int i=sma.length() -1;i>=0;i--){
//             int num1 = Integer.parseInt(((Character)sma.charAt(i)).toString());
//             StringBuilder sb= new StringBuilder();
//            for(int j=big.length() -1;j>=0;j--){
//                int num2 = Integer.valueOf(big.charAt(j));
//                int mul = num1*num2;
//                mul += carry;
//                int lastInt= mul%10;
//                carry = mul/10;
//
//            }
//        }
//        return res;
//    }

}


/*
   Vehicle of one type:
   Multiple entry gate of parking lot:
   vehicle should be able to get spot,
   ticket should be provided with uniq parkingId


    parking spots: [1,2,3,4,5 ....]
    1  is allocated:  ticketId : 1
    1 is freed up
    1 can be allocated: ticketId:1 can be same:
    List<S
    Set<Spot> freeSpot = new HashSet<>() :
    Set<Spot> occupiedSpot = new HashSet<>();

    SpotService{
     List<Spot> list;
     Set<Spot> freeSpot = new HashSet<>() :
     Set<Spot> occupiedSpot = new HashSet<>();
    }

    Spot{

     isOccupied,
     id,
     versionNumber
     }

    isOccupid =true




    set.get();
    wor  : O(n)
    log(n)


 */


