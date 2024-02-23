
import java.util.*;
public class PaypayOnlineAssesment2023 {


    /*
    An array is called palindromic if it remains the same after reversing the order of its elements.

You have an array of strings arr. For each i, arr[i] consists of at least two characters. For each pair of consecutive elements arr[i] and arr[i + 1], you can:

Move the rightmost character of arr[i] to the leftmost position in arr[i + 1]. For instance, "abc" and "def" will become "ab" and "cdef".
This operation can be applied only once to any pair of consecutive elements.

Move the leftmost character of arr[i + 1] to the rightmost position in arr[i].
For instance, "abc" and "def" will become "abcd" and "ef". Again, this operation can be applied only once to any pair of consecutive elements.

Do nothing to the pair of consecutive elements.
Is it possible to obtain a palindromic array from arr by performing these operations?

Example

For arr = ["aa", "bab", "cde", "aba", "ab"], the output should be
solution(arr) = true.

Apply the second operation to "aa" and "bab".
Apply the first operation to "aba" and "ab".
This gives us the following array: ["aab", "ab", "cde", "ab", "aab"], which is palindromic.

For arr = ["palindrome"], the output should be
solution(arr) = true.

The given array is already palindromic, so no operations are needed.

For arr = ["aaaaaa", "aa"], the output should be
solution(arr) = false.

If moving two characters between two consecutive array elements was allowed, the array could have been made palindromic, but this is impossible given the actual rules.

Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] array.string arr

An array of strings.

Guaranteed constraints:
1 ≤ arr.length ≤ 105,
2 ≤ arr[i].length ≤ 10.

[output] boolean

Return true if the given array can be turned into a palindromic array, otherwise return false.
     */

    public static void main(String[] args) {

        PaypayOnlineAssesment2023 paypayOnlineAssesment2023 = new PaypayOnlineAssesment2023();

        System.out.println(paypayOnlineAssesment2023.isPalindromicArray(new String[]{"aa", "bab", "cde", "aba", "ab"}));
        System.out.println(paypayOnlineAssesment2023.isPalindromicArray(new String[]{"aaaaaa", "aa"}));
        System.out.println(paypayOnlineAssesment2023.isPalindromicArray(new String[]{"aaafdasdf"}));
        System.out.println(paypayOnlineAssesment2023.isPalindromicArray(new String[]{"aa", "bab", "aa"}));
        System.out.println(paypayOnlineAssesment2023.isPalindromicArray(new String[]{"aa", "aa", "aa","aa", "aa", "aa","aa", "aa", "aa","aa", "aa", "aa","aa", "aa", "aa","aa", "aa", "aa","aa", "aa", "aa","aa", "aa", "aa"}));
    }
    boolean isPalindromicArray(String[] arr){

        int l=0;
        int r=arr.length-1;
        return isPalindromicArrayUtil(arr,l,r);

//        while(l <r){
//            String left = arr[l];
//            String right = arr[r];
//            if(left.equals(right)){
//                l++;
//                r--;
//            }else{
//                if( r-l >1){
//                    if(canBeMade(left,right)){
//                        if(left.length() < right.length()){
//                            String newLeft = left + arr[l+1].charAt(0);
//                            String newRight = arr[r-1].charAt(arr[r-1].length()-1) + right;
//
//                            if(newLeft.equals(right)){
//                                arr[l+1] = arr[l+1].substring(1,arr[l+1].length());
//                                l++;
//                                r--;
//
//                            }else if( newRight.equals(left)){
//                                arr[r-1] = arr[r-1].substring(0,arr[r-1].length()-1);
//                                r--;
//                                l++;
//                            }
//
//                        }
//                    }else{
//                        return false;
//                    }
//
//                }else{
//                    return false;
//                }
//
//            }
//        }
//

        //return true;
    }
    boolean isPalindromicArrayUtil(String[] arr,int l,int r){

        if( l>=r){
            return true;
        }
        if( r -l >2){
            boolean[] ans=new boolean[4];
            if(arr[l].equals(arr[r])){
                ans[0]=isPalindromicArrayUtil(arr,l+1,r-1);
            }

            modifyLeft(arr,l);
            if(arr[l].equals(arr[r])){
                ans[1]=isPalindromicArrayUtil(arr,l+1,r-1);
            }
            modifyRight(arr,r);
            if(arr[l].equals(arr[r])){
                ans[2]=isPalindromicArrayUtil(arr,l+1,r-1);
            }
            undoLeft(arr,l);
            if(arr[l].equals(arr[r])){
                ans[3]=isPalindromicArrayUtil(arr,l+1,r-1);
            }
            undoRight(arr,r);
            for(boolean res:ans){
                if(res){
                    return true;
                }
            }
            return false;

        }else {
            boolean[] ans=new boolean[3];
            if(arr[l].equals(arr[r])){
                ans[0]=isPalindromicArrayUtil(arr,l+1,r-1);
            }
            modifyLeft(arr,l);
            if(arr[l].equals(arr[r])){
                ans[1]=isPalindromicArrayUtil(arr,l+1,r-1);
            }
            undoLeft(arr,l);
            modifyRight(arr,r);
            if(arr[l].equals(arr[r])){
                ans[2]=isPalindromicArrayUtil(arr,l+1,r-1);
            }
            undoRight(arr,r);
            for(boolean res:ans){
                if(res){
                    return true;
                }
            }
            return false;
        }




    }
    void modifyLeft(String[] arr,int l){
        String newLeft = arr[l] + arr[l+1].charAt(0);
        String newLeft1 = arr[l+1].substring(1,arr[l+1].length() );
        arr[l] = newLeft;
        arr[l+1] = newLeft1;
    }
    void undoLeft(String[] arr,int l){
        String newLeft =  arr[l].substring(0,arr[l].length()-1);
        String newLeft1 = arr[l].charAt(arr[l].length()-1)+arr[l+1];
        arr[l] = newLeft;
        arr[l+1] = newLeft1;
    }
    void modifyRight(String[] arr,int l){
        undoLeft(arr,l-1);
    }
    void undoRight(String[] arr,int l){
        modifyLeft(arr,l-1);
    }
    boolean canBeMade(String left,String right){
        String min = left;
        String max = right;
        if( right.length() <min.length()){
            min= right;
            max = left;
        }
        if(Math.abs(min.length() - max.length()  ) == 1){
            if( max.indexOf(min)>= 0){
                return true;
            }
        }
        return false;
    }
//    boolean isValid()
//    boolean isOperationValid(int l,int r,String[] arr){
//
//        String left = arr
//    }


}
