
import java.util.*;
public class IntuitInterview {



    public static void main (String[] args)
    {
        System.out.println("Hello World!");


        int[] arr=new int[]{16,8,17,6,9,4,7,3,1,10};

        //   int[] arr=new int[]{16};
        //    int[] arr=new int[]{16,5};
//     int[] arr=new int[]{16,8,5};
        sort(arr);
        print(arr);



    }
    static void print(int[] arr){
        for(int v:arr){
            System.out.print(v+" ");
        }
        System.out.println();
    }
   /*
   1,3,5,3,2


   */

    public static void sort(int[] arr){


        int n=arr.length;
        int i=0;
        int j=n-1;

        while(i<j){

            if( arr[j] %2 == 1){
                j--;
            }else if( arr[i] %2 == 0){
                i++;
            }else{
                swap(arr,i,j);
            }
        }
        if( arr[i] %2 == 0){
            i++;
        }
        print(arr);
        System.out.println("i:"+i);
        Arrays.sort(arr,0,i);
        Arrays.sort(arr,i,n);
    }


    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
