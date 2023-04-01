import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GlobalLogicInterview {

    /*

     absadf
     b,s,d,f

     1

     ""
     -1

     */
    public  static void main(String[] args){
        GlobalLogicInterview globalLogicInterview=new GlobalLogicInterview();

//        System.out.println(globalLogicInterview.firstUniqChar("aaab"));// 3
//        System.out.println(globalLogicInterview.firstUniqChar(""));// -1
//        System.out.println(globalLogicInterview.firstUniqChar(null));// -1
//        System.out.println(globalLogicInterview.firstUniqChar("abasab")); // 3
//        System.out.println(globalLogicInterview.firstUniqChar("abcd")); // 3


        List<String> list = Arrays.asList("apple", "banana", "orange", "pear", "watermelon","berry","peach","lemon");

        System.out.println(globalLogicInterview.filterList(list));
        /*""

        abcd

        space complexity:O(n)
        time complexity:O(n)

         */
    }

    /*
Write a Java 8 program that uses Stream API to sort, filter and transform a list of strings.
please process it according to the following requirements:

* Keep only the strings with length 5, apple, lemon, peach, berry
* Convert each string to uppercase: APPLE, LEMON, PEACH, BERRY
* Sort them in alphabetical order
* Print the final result

    public class Main {
        public static void main(String[] args) {
// Create a list of strings
            List<String> list = Arrays.asList("apple", "banana", "ora

            List<String> list = Arrays.asList("apple", "banana", "orange", "pear", "watermelon","berry","peach","lemon");

            APPLE,BERRY,LEMON,PEACH
 */

    List<String> filterList(List<String> list){

        return list.stream().filter((s)->s.length() ==5).map((a)-> (a.toUpperCase())).sorted().collect(Collectors.toList());
    }


    public int firstUniqChar(String  s) {
        if(s == null){
            return -1;
        }

        Map<Character,Integer> countMap=new HashMap<>();
        Map<Character,Integer> indexMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(countMap.get(c) != null){
                int count= countMap.get(c);
                countMap.put(c,count+1);
            }else{
                countMap.put(c,1);
                indexMap.put(c,i);
            }
        }
        int ans=-1;
        for(Map.Entry<Character,Integer> entry: countMap.entrySet()){
            if(entry.getValue() == 1){
                int ind= indexMap.get(entry.getKey());
                if(ans == -1){
                    ans= ind;
                }else if(ind< ans){
                    ans=ind;
                }
            }
        }
        return ans;


    }


}
