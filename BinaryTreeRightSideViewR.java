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
 * Time Complexity = O(N) where N is the number of nodes in the tree
 * Space Complexity = O(N) where N is the number of nodes in the binary tree
 * LeetCode: Y (https://leetcode.com/problems/binary-tree-right-side-view/)
 * Approach: 
    Post-order traversal means that the right child is visited last so the following approach works
    Do a DFS post-order traversal and tracking each level 
    if the arraylist size equals level then the traversal reached this level for the first time so append the root val to the result arraylist
    else update the value at level index of the result to the root val
 */
class Solution {
    List<Integer> rightView;
    public List<Integer> rightSideView(TreeNode root) {
        // initialize result arraylist 
        rightView = new ArrayList<>();
        
        // check edge case
        if(root == null) {
            return rightView;
        }
        
        // Start DFS from root tracking the level
        dfs(root, 0);
        
        // return result
        return rightView;
    }
    
    // Helper function to perform DFS
    private void dfs(TreeNode root, int level) {
        // Base Condition
        if(root == null) {
            return;
        }
        
        //  if the arraylist size equals level then the traversal reached this level for the first time so append the root val to the result arraylist
        if(level == rightView.size()) {
            rightView.add(root.val);
        }
        // else update the value at level index of the result to the root val
        else {
            rightView.set(level, root.val);
        }
        
        // Explore left sub tree
        dfs(root.left, level + 1);
        
        // Explore right sub tree
        dfs(root.right, level + 1);
    }
}
