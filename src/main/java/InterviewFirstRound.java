

public class InterviewFirstRound {
/*


1->2->3

3->2-1
1->2->3

1  2

   1->2->3->4->5->3

   l1+l2= l

   l1+l3


   O(n)
   inorder
   sc: O(1)


   ans :3,

   fast,



 */

    public static void main(String[] args) {

    }


    static  NodeList reverseList(NodeList head){

        NodeList prev=null;
        NodeList cur=head;
        NodeList next=null;

        while(cur != null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;

    }
    /*

    int prev=Integer.MIN_VALUE;
    boolean isBst(Node root){
       if(root != null){
            boo
       }
    }

    t1: 0
    t2:1
    t3:2
    t1:4
    t2:5
    t3:6
    at:
   t1: num%numberOfthreds==0 System.
   inc: at
   w


     */
}
class  NodeList{
    int val;
    NodeList next;
}
