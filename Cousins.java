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
class Cousins {
    // Time Complexity:     O(n)    traverse through all the nodes
    // Space Complexity:    O(n)    recursive stack
    
    //Four pointers needed
    int depthX;
    int depthY;
    TreeNode parentX;
    TreeNode parentY;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        
        recursive(root, x, y, 0, null);
        
        return depthX == depthY && parentX.val != parentY.val;
    }
    
    public void recursive(TreeNode root, int x, int y, int depth, TreeNode parent){
        
        // If found ==> update the pointers
        if(root.val == x){
            depthX = depth;
            parentX = parent;
        } else if(root.val == y){
            depthY = depth;
            parentY = parent;
        }
        
        // DFS
        if(root.left!= null)
            recursive(root.left, x, y, depth + 1, root);
        if(root.right!= null)
            recursive(root.right, x, y, depth + 1, root);   
    }
}