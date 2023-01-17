package geeksforgeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeToBST {
   
	NodeTwo binaryTreeToBST(NodeTwo root)
    {
	   // Your code here
		preorder(root);
		Collections.sort(list);
		util(root);
		
		
		
		return root;
    }
	int index=0;
	void util(NodeTwo nodeTwo){
		if(nodeTwo !=null)
		{
			util(nodeTwo.left);
			int val= nodeTwo.data;
			nodeTwo.data=list.get(index);
			index++;
			util(nodeTwo.right);
			
			
		}
		
	}
    List<Integer> list=new ArrayList<Integer>();
    
    void preorder(NodeTwo nodeTwo){
    	if(nodeTwo !=null)
    	{
    		list.add(nodeTwo.data);
    		preorder(nodeTwo.left);
    		preorder(nodeTwo.right);
    	}
    }
}
