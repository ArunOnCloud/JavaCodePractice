

/*
Given two sorted arrays A1 and A2 of size M and N respectively, return the median of the two sorted arrays.

public int median(int[] A1, int[] A2)

Try to decrease complexity below O(m+n)

O(m+n)

1,4,6
2,4

1,2,4,5,4,6
median:  (4+5)/2; 4.5

len : m+n

len is odd m+n/2
len is even m1=m+n/2 , m2=m+n/2 + 1

m1

i : pointer at A1
j : pointer ar A2
 */
public class EpamSecondInterviewSecondQuestion {

    public static void main(String[] args) {
        int[] A1= new int[]{1,2,3,10};
        int[] A2= new int[]{22,20,30,50};
        System.out.println(median(A1,A2));
    }
    static public int median(int[] A1, int[] A2){
        int m = A1.length;
        int n = A2.length;
        int len = m+n;

        int mid= len/2;
        int i=0;
        int j=0;
        int count=0;
        int prev= Integer.MIN_VALUE;
        while(true){
            int f=Integer.MAX_VALUE;
            int s= Integer.MAX_VALUE;
            if(i<m){
                f = A1[i];
               // i++;
            }
            if(j <n){
                s = A2[j];
                //j++;
            }
            if(f < s){
                prev = A1[i];
                i++;
            }else if( s<f){
                prev = A2[j];
                j++;
            }else if( f== s){
                prev = A1[i];
                i++;
            }
            count++;
            if(count == mid){
                break;
            }

        }

        if(len%2 == 1){
           // if(prev)
            int second = getSecond(A1, A2, i, m, j, n);

            return second;
        }else{
            int second = getSecond(A1, A2, i, m, j, n);
            return (prev + second)/2;
        }

    }

    private static int getSecond(int[] A1, int[] A2, int i, int m, int j, int n) {
        int second =Integer.MIN_VALUE;
        if(i < m && j < n){
            second = Math.min(A1[i], A2[j]);
        }else{
            if( i < m){
                second = A1[i];
            }else{
                second = A2[j];
            }
        }
        return second;
    }

}
