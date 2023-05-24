import java.util.LinkedList;
import java.util.List;

public class TescoQuestion {

    /*

    Word wrap

    word api

     intput: this is something

     width:10 char (n )
     ensure : optise the space
     1) between two words only 1 space
     optimise the space in trail

     if word >n
     break it wrap it next line

     umbrella
     fix number : 8



     4
     umbreall

     umb-
     rea-
     ll

      input : string and widthofline
      maxWordWidth,

      2
      adfasdfasdfadf
      a

      width 7
      abs asd asd

      abs asd
      asd
     */
    public static void  main(String[] args){
        LineWrapper lineWrapper=new LineWrapperImpl();
        String para= "adsf asdfkasd fasdfasd";
        System.out.println(lineWrapper.wrapPragraph(para,5,4));
    }
}
interface LineWrapper{
    List<String> wrapPragraph(String pragraph, int width, int maxWordLength);

}

class LineWrapperImpl implements  LineWrapper{

    int maxWordLength;
    int width;
    public  List<String> wrapPragraph(String paragraph, int width, int maxWordLength){
        this.width=width;
        this.maxWordLength=maxWordLength;
        String str=paragraph.trim();
        List<String> result=new LinkedList<>();
        String[] words=str.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String w:words){
//            if(w.length() > maxWordLength){
//                String str1= w.substring(0,maxWordLength);
//                String str2=w.substring(maxWordLength-1,w.length());
//                sb.append(str1);
//                list.add(sb.toString());
//                sb=new StringBuilder();
//                sb.append(str2);
//            }else{
//                if(sb.length() +w.length()+ 1 > width){
//                    int len =sb.length();
//                    int wLen= w.length();
//                    int n= width-len -1;
//                    String str1= w.substring(0,n);
//                    String str2=w.substring(n-1,w.length());
//                    sb.append(" "+str1);
//                    list.add(sb.toString());
//                    sb=new StringBuilder();
//                    sb.append(str2);
//                }
//            }

            List<String> list1=handleMaxWordLength(w);
            if(list1.size() >1){
                String firstWord= list1.get(0);
                sb.append(""+firstWord);
                List<String> list2= handleWidthLength(sb.toString());
                result.addAll(list2);
                for(int i=0;i<list1.size();i++){
                    if( i == 0 || i == list1.size() -1){
                        continue;
                    }
                    result.add(list1.get(i));
                }
                sb=new StringBuilder(list1.get(list1.size() -1));

                List<String> list3= handleWidthLength(sb.toString());
                result.addAll(list3);
                sb=new StringBuilder();

            }

        }
        return result;

    }
    List<String> handleMaxWordLength(String w){
        List<String> res=new LinkedList<>();

        if( w.length() <= width){
            return res;
        }
        int ind=0;
        while(ind <w.length()){
            String str1= w.substring(ind,maxWordLength);
            res.add(str1);
           ind= ind+maxWordLength;
        }

        return res;
    }
    List<String> handleWidthLength(String str){
        List<String> res=new LinkedList<>();
        if( str.length() >width){
            String str1=str.substring(0,width);
            String str2=str.substring(width-1,str.length());
            res.add(str1);
            res.add(str2);
        }
        return res;
    }
}
