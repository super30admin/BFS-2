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
// Time Complexity: We are traversing all the nodes providing O(n) time complexity
// Space Complexity: No additional datastructure used O(1)
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach here
// Idea here is to use DFS by maintaining both depth as well as parent of each found node.
// In recursion root value is checked for finding x, if found depth is recorded and parent is recorded, similarly depth of y and parent of y is recorded separately.
// we keep recursing to left and right until x and y are found or recursion has completed.
// finally if both x and y have same depth but different parents, true is returned else false is returned
class Solution {
    TreeNode parentX; TreeNode parentY;
    int depthX; int depthY;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || root.val==x || root.val==y) return false;
        helper(root, x, y, 0, null);
        return depthX == depthY && parentX!=parentY;
    }
    
    public void helper(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root==null) return;
        
        if(root.val==x) {
            depthX = depth;
            parentX = parent;
        }
        if(root.val == y) {
            depthY = depth;
            parentY = parent;
        }
        helper(root.left, x,y,depth+1, root);
        helper(root.right, x,y,depth+1, root);
    }
}