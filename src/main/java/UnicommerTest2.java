public class UnicommerTest2 {


    /*

    {-2,1,2,4,-8,2,1,7,-7,2,-6}


    i=0;

    i=1
     j = 4 ,-8
    -2,1,2,4,-8
    -2,-8,1,2,4
    i= j+1
    arr[i]

    O(n)

    left to right


     */

    public static void main(String[] args) {
        UnicommerTest2 unicommerTest2 = new UnicommerTest2();
        int[] arr = new int[]{-2,1,2,4,-8,2,1,7,-7,2,-6};
       // int[] arr = new int[]{-2,-1,3,-4,3};
     //   int[] arr = new int[]{1,-2,-3};
        unicommerTest2.segragatePositiveAndNegative(arr);
        unicommerTest2.print(arr);
    }
    void util(int[] arr){

    }

    void   segragatePositiveAndNegative(int[] arr){

        int n = arr.length;
        int i=0;
        int j=0;

        while(i < n){

            if( arr[i] >=0){
                j = i+1;
                while(j< n && arr[j] >=0){
                    j++;
                }
                if( j<n){
                    int j1= j-1;
                    while( j1>= i){
                         int temp = arr[j1+1];
                         arr[j1+1] = arr[j1];
                         arr[j1]=temp;
                         j1--;
                    }
                }
                i = j;
            }else{
                i++;
            }
        }

    }
    void print(int[] arr){
        for(int v: arr){
            System.out.print(v+ " ");
        }
        System.out.println();
    }
}
