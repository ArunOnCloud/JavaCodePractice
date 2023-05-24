package reviewCode;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public  class SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return util(root,subRoot);
    }
    boolean util(TreeNode root1,TreeNode root2){ // name should be more convincing like make it isSubtree function
        if(root1!= null){
            if(isEqual(root1,root2)){
                return true;
            }

            boolean left= util(root1.left,root2);
            if(!left){
                return util(root1.right,root2);
            }
            return left;
        }
        return false;
    }

    boolean isEqual(TreeNode root1,TreeNode root2){ // add comments what it does and waht can be parameters scope
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 != null && root2 != null){
            if(root1.val != root2.val){
                return false;
            }
            boolean left=isEqual(root1.left,root2.left);
            if( !left){
                return false;
            }
            return isEqual(root1.right,root2.right);
        }
        return false;
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
