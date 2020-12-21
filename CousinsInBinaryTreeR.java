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
/**
 * Time Complexity = O(N) where N is the number of nodes in the binary tree
 * Space Complexity = O(N) where N is the number of nodes in the binary tree
 * LeetCode: Y (https://leetcode.com/problems/cousins-in-binary-tree/)
 * Approach:
    Do a DFS traversal
    check if root is x and then update x details
    check if root is y and then update y details
    Explore left sub-tree
    Explore right sub-tree
 */

class Solution {
    // variable to store x Level and y Level
    int xLevel, yLevel;
    
    // variable to store x parent and y parent
    TreeNode xParent, yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        // check edge case
        if(root == null) {
            return false;
        }
        
        // Start DFS from root
        dfs(root, null, x, y, 0);
        
        // if x and y are at the same level and don't have same parent node then return true else return false
        return (xLevel == yLevel && (xParent != yParent));
    }
    
    
    private void dfs(TreeNode root, TreeNode parent, int x, int y, int level) {

        // check base condition and already met conditions for x and y to be cousins
        if(root == null || (xLevel == yLevel && (xParent != yParent))) {
            return;
        }
        
        // if val of current node is x then update xLevel and xParent 
        if(root.val == x) {
            xLevel = level;
            if(parent != null) {
                xParent = parent;
            }
        }
        
        // if val of current node is y then update yLevel and yParent 
        if(root.val == y) {
            yLevel = level;
            if(parent != null) {
                yParent = parent;
            }
        }
        
        // Explore left sub-tree
        dfs(root.left, root, x, y, level + 1);
        
        // Explore right sub-tree
        dfs(root.right, root, x, y, level + 1);
    }
}
