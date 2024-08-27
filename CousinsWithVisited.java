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

// this is done so that the recursion can be stopped more effectively. (Boolean value does not allow that.)
// 0 state <- both are not found
// 1 state <- both are found and they are siblings
// 2 state <- both are found and they are not siblings
class CousinsWithVisited {
    int visited;
    int x_depth;
    int y_depth;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,0, x,y);
        if(visited ==1 ) {
            return false;
        }
        return x_depth==y_depth;
    }
    
    private void helper(TreeNode root, int depth, int x , int y ) {
        if(visited!=0) {
            return;
        }
        if(root==null) {
            return;
        }
        if(root.left!=null && root.right!=null) {
            if(root.left.val ==x  && root.right.val == y) {
                visited = 1;// both are found and they are siblings.
                return;
            }
            if(root.left.val ==y  && root.right.val == x) {
                visited = 1;// both are found and they are siblings.
                return;
            }
        }
        if(root.val == x) {
            if(y_depth!=0) {// y is already found.
                visited =2;
            }
            x_depth = depth;
        }
        if(root.val == y) {
            if(x_depth!=0) {// x is already found.
                visited =2;
            }
            y_depth = depth;
        }
        
            helper(root.left, depth+1, x, y );
            helper(root.right, depth+1, x, y );            
        

        return;
    }
}