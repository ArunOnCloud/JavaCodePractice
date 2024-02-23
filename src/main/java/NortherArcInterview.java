public class NortherArcInterview {

    /*

    print X
    input h,w
    2,3

    XXX
    XXX
    4,3

    3,3
    X.X
    .X.
    X.X

    2,2,
    XX
    XX

    1,4

    X..X

    1,1
    .

    2,1
    .
    .
    3,3 and above

    4,3

    X.X
    .X.
    .X.
    X.X
    4,4
    X..X
    .XX.
    .XX.
    X..X

    0,0
    1,1
    2,2
    3,3



     */

    public static void main(String[] args) {
//        printX(3,3);
//        printX(6,6);

        printX(2,3);
//        printX(10,20);
//        printX(25,30);
//        printX(1,4);
//        printX(,6);

    }
   static void printX(int r1,int c1){
        int r=Math.max(r1,c1);
        if(r%2==1){
            r=r+1;
        }

        int c=Math.max(r1,c1);
        if(c%2 == 1){
            c= c+1;
        }
        String[][] arr= new String[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=" ";
            }
        }

        int i=r/2;
        int j=c/2;
        // down direction right
        while(i<r && j<c){
            arr[i][j]="X";
            i++;
            j++;
        }
        //down left
        i=r/2;
        j=c/2;
        while(i<r && j>=0){
            arr[i][j]="X";
            i++;
            j--;
        }
        // up right
       i=r/2;
       j=c/2;
       while(i>=0 && j<c){
           arr[i][j]="X";
           i--;
           j++;
       }
       // up left
       i=r/2;
       j=c/2;
       while(i>=0 && j>=0){
           arr[i][j]="X";
           i--;
           j--;
       }
       printArr(r, c, arr);
   }

   /*

   <a>
     <b>
     </b>
   </a>

   <Employee>
     <name>
      <firstName>
      </firstName>
     </name>
     <dob>
     </dob>
     <abc>
     </abc>
   </Employye>

   nodeA
     children of type
     Node{
     String name
     Set<Node> children=TreeSet<>()
     }

     tree1Node


     tree2Node

     tc: O(v+e)
     sc: O(v+e)
     |\
     b c
    */

    private static void printArr(int r, int c, String[][] arr) {
        for(int i1 = 0; i1< r; i1++){
            for(int j1 = 0; j1< c; j1++){
                System.out.print(arr[i1][j1]);
            }
            System.out.println();
        }
    }
}
