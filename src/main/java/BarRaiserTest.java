import java.util.*;

public class BarRaiserTest {


    public static void main(String[] args) {
        String[] strs=new String[]{"sum(10)(100)(1000)","div(1000)(2)(30)","sub(3)(2)(7)","mul(12)(12)(8)","sum(98)"};
        BarRaiserTest barRaiserTest=new BarRaiserTest();
        for(String str:strs){
            System.out.println(barRaiserTest.evaluate(str));
        }

        System.out.println(barRaiserTest.groupAnagrams(List.of("rat", "abc", "tar", "abcd", "tar", "bca")));
    }

    /*

    List<List<String>> list
    rat, abc, tar, abcd, tar, bca

    rat


     rat,tar,tar,abc,bca,abcd

     isAnagram(String a,String b){
     }




     */

    List<List<String>> groupAnagrams(List<String> strings){

        Set<Integer> visited=new HashSet<>();

        List<List<String>> result=new LinkedList<>();
        for(int i=0;i<strings.size();i++){
            String a=strings.get(i);
            List<String> list=new LinkedList<>();
            list.add(a);
            if(visited.contains(i)){
                continue;
            }

            visited.add(i);
            for(int j=i+1;j<strings.size();j++){
                String b=strings.get(j);
                if(!visited.contains(j) && isAnagram(a,b)){
                    list.add(b);
                    visited.add(j);
                }
            }
            result.add(list);
        }
        return  result;

    }
    boolean isAnagram(String a,String b){
        int[] arr1=new int[128];
        int[] arr2=new int[128];
        for(char c: a.toCharArray()){
            int ind= (int)c;
            arr1[ind]++;
        }
        for(char c: b.toCharArray()){
            int ind= (int)c;
            arr2[ind]++;
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }


    public Double evaluate(String str){
        //Map<String,>
        int n= str.length();
        if( n<3){
            return 0.0;
        }
        String operation= str.substring(0,3);
        List<Double> list=new LinkedList<>();
        int ind=3;
        while(ind <n){
            int j= ind+1;
            StringBuilder sb=new StringBuilder();
            while(str.charAt(j) != ')'){
                sb.append(str.charAt(j));
                j++;
            }
            sb.append(".");
            list.add(Double.parseDouble(sb.toString()));
            ind= j+1;
        }
        Double start= list.get(0);
        if(operation.equals("sum")){
            for(int i=1;i<list.size();i++){
                start+=list.get(i);
            }
        }else if( operation.equals("sub")){
            for(int i=1;i<list.size();i++){
                start-=list.get(i);
            }
        }else if(operation.equals("mul")){
            for(int i=1;i<list.size();i++){
                start*=list.get(i);
            }
        }else if(operation.equals("div")){
            for(int i=1;i<list.size();i++){
                start/=list.get(i);
            }

        }


        return start;
    }
}
