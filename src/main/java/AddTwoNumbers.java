

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class AddTwoNumbers {


    /*

    2+3 = 5

    length of string :
    0-9

    1234566
        123
    -------
    1234689
    -99
     1
     98
    */

    static String addNumbers(String a, String b) {
        String a1=a;
        String a2=b;
        if( b.length()> a.length()){


            a1=b;
            a2=a;
        }

        int f1=0;
        if( a1.charAt(0) == '-'){
            f1=1;
            a1 = a1.substring(1,a1.length());
        }
        int f2 =0;
        if( a2.charAt(0) == '-' ){
            f2 =1;
            a2 = a2.substring(1,a2.length());
        }
        if( a1.length() == a2.length()){
            if( a1.compareTo(a2) <0){
                String temp= a1;
                a1= a2;
                a2 = temp;
            }
        }

        StringBuilder sb= new StringBuilder();
        int j=a2.length()-1;
        Integer carry=0;
        for(int i=a1.length() -1; i>=0;i--){
            Character m1= a1.charAt(i);
            int op1 = Integer.parseInt(m1.toString());
            int op2 = 0;
            if( j>=0){
                Character m2= a2.charAt(j);
                op2 = Integer.parseInt(m2.toString());
                j--;
            }
            int carryF= 0;
            if( f1 == 1 && f2 == 1){

            }else if( f1 ==1 || f2 == 1){
                if( f1 == 1){
                    op1 = (-op1);

                    if( Math.abs(op1) < Math.abs(op2)){
                        op1 = op1 -10;
                        carryF =1;
                    }
                }
                if( f2 == 1){
                    op2 = (-op2);
                }

            }
            System.out.println( "op1:"+ op1+ " op2:"+ op2+ " carry:"+carry + " i :"+i );
            Integer sum = op1+op2+carry;

            carry = sum/10;
            sum = sum%10;
            if( f1 == 1){
                if( carryF == 1){
                    carry = 1;
                }

            }

            sb.insert(0,Math.abs(sum));
        }
        if( carry >0){
            sb.insert(0,carry.toString());
        }
        if( f1 == 1 && f2 ==1 ){
            sb.insert(0, '-');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String a;
//        a = in.next();
//        String b;
//        b = in.next();
        String sum;

        sum = addNumbers("-23", "1");
        System.out.println(sum);
    }
}
