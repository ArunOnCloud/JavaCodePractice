package geeksforgeeks;

import java.util.*;
import java.util.Scanner;

class NodeTwo
    {
        int data;
        NodeTwo left,right;
        NodeTwo(int d) {data = d; left =right= null; }
    }
		
public class GFG2
{
    public static NodeTwo target;
    GFG2(){
        target=null;
    }
	public static void inorder(NodeTwo root, int key)
	{
	    if(root==null)
	    return;
	    inorder(root.left,key);
	    if(root.data==key)
	    target=root;
	    inorder(root.right,key);
	}
     /* Drier program to test above functions */
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t-->0)
         {
			int n = sc.nextInt();
			GFG2 llist=new GFG2();
			NodeTwo root=null,parent=null;
			HashMap<Integer, NodeTwo> m = new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                char c=sc.next().charAt(0);
                if(m.containsKey(a)==false)
                {
                    parent=new NodeTwo(a);
                    m.put(a,parent);
                    if(root==null)
                    root=parent;
                }
                else
                    parent=m.get(a);
                NodeTwo child=new NodeTwo(b);
                if(c=='L')
                parent.left=child;
                else
                parent.right=child;
                m.put(b,child);
            }
            int key=sc.nextInt();
            inorder(root,key);
            int k=sc.nextInt();
            GFG obj = new GFG();
            obj.printkdistanceNode(root,target,k);
            System.out.println();
		}
	}
}

class GFG
{
    public static int printkdistanceNode(NodeTwo root, NodeTwo target , int k)
    {
    //Add your code here.
      List<NodeTwo> list=new LinkedList<>();
      findPathToNode(root,target,list);
      NodeTwo prev=null;
      for(int i=list.size()-1;i>=0;i--){
         NodeTwo nodeTwo =list.get(i);
         if(prev ==null){
             prev= nodeTwo;
            // print(node,target,k);
         }else{
             int k1=list.size()-1 -i;
             NodeTwo next=null;
             if(nodeTwo.left.data== prev.data){
                // print(node.right,target,k1);
             }else{
                // print(node.left,target,k1);
             }
         }
      }
      return 0;
    }
    
    static boolean findPathToNode(NodeTwo nodeTwo, NodeTwo target, List<NodeTwo> list){
        if(nodeTwo != null){
            if(nodeTwo.data == target.data){
                list.add(target);
                return true;
            }
            
            boolean l=findPathToNode(nodeTwo.left,target,list);
            boolean r=findPathToNode(nodeTwo.right,target,list);
            if((l||r)){
                
            }else{
                list.remove(nodeTwo);
            }
        }
        return false;
        
    }

    static void print(NodeTwo root, int c, int k){
        if(root != null){
            if( c== k){
                System.out.print(root.data+" ");
                return;
            }
            print(root.left,c+1,k);
            print(root.right,c+1,k);
        }
    }
}
