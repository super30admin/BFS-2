
//993. Cousins in Binary Tree EASY.java

//Time Complexity: O(n)
//Space Complexity: O(max(depth))
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int x_height = -1;
    TreeNode x_parent = null;
    TreeNode y_parent = null;
    int y_height = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        helper(root, null, x, y, 0);
        //System.out.println(x_height);
        
        //System.out.println(y_height);
        //System.out.println(x_parent.val);
        
        ////System.out.println(y_parent.val);
        return (x_height == y_height && x_parent != y_parent);
    }
    public void helper(TreeNode root,TreeNode parent, int x, int y, int depth){
            if(root == null)
                return;
            
            if(x_height != -1 && y_height != -1){
                //found both heights
                return;
            }
        
            //System.out.println("root" + root.val);
            //get height of x node
            if(root.val == x){
                x_height = depth;
                x_parent = parent;
            }
        
            //get height of y node
            if(root.val == y){
                y_height = depth;
                y_parent = parent;
            }
        
            //search on left subtree
            helper(root.left, root, x, y, depth + 1);
            //search on right subtree
            helper(root.right, root, x, y, depth + 1);
    }

}