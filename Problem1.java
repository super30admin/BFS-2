// Time Complexity: O(n)
// Space complexity: O(max(depth))

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
    
    int depth_x = -1;
    int depth_y = -1;
    TreeNode parent_x = null;
    TreeNode parent_y = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        recurr(root, 0, x, y, null);
        return (depth_x == depth_y) && (parent_x.val != parent_y.val); 
    }
    
    public void recurr(TreeNode node, int depth, int x, int y, TreeNode parent){  
        // For elements to be cousins: 
        // 1. depth is equal
        // 2. parent is not equal 
        
        // need track of depth 
        // need track of parents
        // Does the order matter? No
        
        if(node == null){
            return;
        }
        
        if(node.val == x && parent_x == null){
            depth_x = depth;
            parent_x = parent;
        }
        
        if(node.val == y && parent_y == null){
            depth_y = depth;
            parent_y = parent;
        }
        
        recurr(node.left, depth+1, x, y, node);
        recurr(node.right, depth+1, x, y, node);
    }
}
