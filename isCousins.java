//Time Space : O(n)
//Space Complexity : O(1)
/* Description : we will be travesing through out the tree to find the x & y values, once found
 we will store the level and also parent of x & y. If parent do not match and level match then we return true 
 else false.
 */
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
class Solution {
    TreeNode x_Parent; // stores x's parent
    TreeNode y_Parent; // stores y's parent
    int x_Depth;// stores x's level
    int y_Depth;// stores y's level
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,0,null,x,y);
        return (x_Depth == y_Depth) && (x_Parent != y_Parent);
        
    }
    public void helper(TreeNode root, int level, TreeNode parent, int x, int y){
        //base
        if(root == null) return;
        if(x_Depth!= 0 && y_Depth!= 0) return;
        //logic
        if(root.val == x){ // checking if x matches with the root then store the level and get its parent
            x_Parent = parent;
            x_Depth = level;
        }

        if(root.val == y){// checking if y matches with the root then store the level and get its parent
            y_Parent = parent;
            y_Depth = level;
        }
        //left side traversal of tree
        helper(root.left,level+1,root,x,y); 
        //right side traversal of tree
        helper(root.right,level+1,root,x,y);
    }
}