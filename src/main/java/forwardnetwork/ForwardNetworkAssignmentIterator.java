package forwardnetwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class ForwardNetworkAssignmentIterator {


    public static void main(String[] args) throws Exception{
        ArrayList<String> arrayList=new ArrayList<>();

        List<String> list= List.of("arun","faf","facebook","arunKumar","arunKum");


        Iterator itr=arrayList.iterator();
        //itr.
        Iterator<String> itr1=list.iterator();
        String fixLetterWordPattern= "/^.{7}$/";
        StringPatternIterator stringPatternIterator=new StringPatternIterator(itr1,fixLetterWordPattern);


    }
}
class StringPatternIterator implements Iterator<List<String>>{


    private String patternStr;
    private Iterator<String> itr;
    Pattern pattern;
    String prevString="";
    StringPatternIterator(Iterator<String> itr,String pattern){
        this.patternStr=pattern;
        this.itr=itr;
        this.pattern = Pattern.compile(patternStr);
    }
    @Override
    public boolean hasNext() {
        if(prevString != null && prevString.length() >0){

        }
        return false;
    }

    @Override
    public List<String> next() {
        return null;
    }


}
