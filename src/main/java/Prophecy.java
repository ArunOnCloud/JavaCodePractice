import java.util.Stack;

public class Prophecy {

    public static void main(String[] args){
        System.out.println(postFixToInfix("23+45+-"));
        System.out.println(postFixToInfix("2345++-"));
        System.out.println(postFixToInfix("45+"));
    }

    public static String postFixToInfix(String str){
        Stack<String> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char c= str.charAt(i);
            if( c>='0' && c<='9'){
                s.add(""+c);
            }else{
                String s1=s.pop();
                String s2=s.pop();
                String f1="";
                if( s1.length() == 1){
                    f1=s2;
                }else if(c == '*' || c=='/'){

                }
                String f2="";
                if(s2.length() ==1){
                    f2=s1;
                }
                String exp="("+s2+")" + c+"("+s1+")";
                s.add(exp);
            }
        }
        return s.peek();

    }
}



/*

523+45+**
5 (2+3)*(4+5)
5*(2+3)*(4+5)

5/((2+3)*(4+5))
5+(2+3)*(4+5)
5-(2+3)*(4+5)




a/b
b/a

5 :(2+3)
5 (2+3)

* or /

23+45+-

2+3-(4+5)


s1 2,3
2+3 =
s2: 2+3
s1:4,5
s2: 2+3 :4+5
s1: empty
s2: (2+3) -(4+5)
5+



34-5-
2345++-
45+

345++
3+4+5
(2)
2
3+4+5
3+4-5
3+4*5
3+4/5

(2)-((3)+((4)+(5)))
((3+4)/(3))*5

2345++-
2-(3+4+5)

(2)-((3)+((4)+(5)))

s: 0

(4+5)+(2+3)




 */
