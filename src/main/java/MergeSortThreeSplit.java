



public class MergeSortThreeSplit {

    public static void main(String[] args)throws Exception{

        int[] arr={2,2,-1,2,-987,1234,9,8};
        MergeSortThreeSplit mergeSortThreeSplit=new MergeSortThreeSplit();
        mergeSortThreeSplit.mergeSort(arr,0,arr.length-1);
        mergeSortThreeSplit.print(arr);


    }
    void print(int[] arr){
        for(int v:arr){
            System.out.print(" "+v);
        }
        System.out.println();
    }
    /*

      O(nlogn) in log base is 3
      O(nlogn) space timecomplexity
     n 1,5
     n  1,2   3,5
     */
    void mergeSort(int[] arr,int l,int r){

        if( l == r){
            return;
        }
        if( r <l){
            return;
        }

        if(r-l+1 <3){
            if( arr[l] >arr[r]){
                int temp= arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
            }
            return;
        }
        int divLen = (r-l+1)/3;
        int firstMid= l+divLen;

        int secondMid = firstMid + divLen;

        mergeSort(arr,l,firstMid-1);
        mergeSort(arr,firstMid,secondMid-1);
        mergeSort(arr,secondMid,r);

        int len = r-l+1;
        merge(arr,l,firstMid-1,arr,firstMid,secondMid-1);
        merge(arr,l,secondMid-1,arr,secondMid,r);

    }
    void merge(int[] arr1,int i,int j,int[] arr2,int l,int r){
        int len= r-l+1 +j-i+1;
        int[] sortArr=new int[len];
        int start=i;
        int ind=0;
        while( ind <len){
            int temp1=Integer.MIN_VALUE;
            int temp2=Integer.MIN_VALUE;

            if( i<=j){
                temp1= arr1[i];
            }
            if(l <=r){
                temp2= arr2[l];
            }
            if(temp1 == Integer.MIN_VALUE){
                sortArr[ind]=temp2;
                j++;
            }else if(temp2 == Integer.MIN_VALUE){
                sortArr[ind]=temp1;
                i++;
            }else if( temp1 <temp2){
                sortArr[ind]=temp1;
                i++;
            }else{
                sortArr[ind]=temp2;
                l++;
            }
            ind++;
        }

         ind=0;
        for(int i1=start;i1<=r;i1++){
            arr1[i1]= sortArr[ind];
            ind++;
        }
    }


}
