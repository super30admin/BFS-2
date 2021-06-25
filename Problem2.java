// 993. Cousins in Binary Tree

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
    int depthX = -1;
        int depthY = -1;
        
        TreeNode parentX = null;
        TreeNode parentY = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        
        helper(root, x, y, null, 0);
        if ((depthX == depthY) && (parentX != parentY)) return true;
        else return false;
            
    }
    
    public void helper(TreeNode root, int x, int y, TreeNode parent, int depth) {
        
        if (root == null) return;
        
        if (root.val == x) {
            depthX = depth;
            parentX = parent;
        } else if (root.val == y) {
            depthY = depth;
            parentY = parent;
        }
        
        if (depthX != -1 && depthY != -1) {
            return;
        }
        
        helper(root.left, x, y, root,   depth + 1);
        helper(root.right, x, y, root,   depth + 1);
           
    }
}

/*
Time Complexity: 
O(N), where N is the number of nodes in the binary tree. In the worst case, we might have to visit all the nodes of the binary tree.
Space Complexity: O(N). In the worst case, we need to store all the nodes of the last level in the queue
*/