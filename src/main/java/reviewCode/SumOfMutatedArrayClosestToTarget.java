package reviewCode;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget {

    public int findBestValue(int[] arr, int target) {
        int maxValue= 100000; // write it as threshold max thresholo
        Arrays.sort(arr);
        int absDiff= Integer.MAX_VALUE; // minimum absolute difference
        int ans=-1; // value answere
        int i=1;
        int len= arr.length; // write full words to variable make it more readable

        int[] pre=new int[len];  // write it as prefix sum array
        int sum=0;
        for(int j=0;j<len;j++){
            sum+=arr[j];
            pre[j]=sum;
        }

        for(i =0;i<=maxValue;i++){

            int ind = getInsertionIndexInArrayOfGivenValue(arr, i);
            int totalSum = determineTotalSumAfterOperation(i, len, pre, ind);
            int diff = Math.abs( target-totalSum);
            if(diff >0){
                // System.out.println(diff+ " n:"+n+ " i:"+i+" index:"+index+" totalSum:"+totalSum+" ind:"+ind);
            }
            if(diff < absDiff){
                absDiff=diff;
                ans=i;
            }
        }
        return ans;

    }

    private static int determineTotalSumAfterOperation(int i, int len, int[] pre, int ind) {
        int n= len - ind; // totalNumber of elements greater than current value
        int totalSum=0;
        if(ind >= len){
            totalSum= pre[len -1];
        }else{
            if(ind == 0){
                totalSum = (n* i);
            }else{
                totalSum=(pre[ind -1]+n* i);
            }

        }
        return totalSum;
    }

    private static int getInsertionIndexInArrayOfGivenValue(int[] arr, int i) {
        int index= Arrays.binarySearch(arr, i);
        int ind=-1; // write it as insertion index
        if(index <0){
            ind= -(index +1);
        }else{
            ind=index;
        }
        return ind;
    }
}
