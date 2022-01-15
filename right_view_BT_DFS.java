// Time Complexity : O(n)
// Space Complexity : O(n)

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
    
    List<Integer> rightView;
    public List<Integer> rightSideView(TreeNode root) {
        
        // result
        rightView = new ArrayList<>();
        
        // Apply DFS from root
        dfs(root, 0);
        
        return rightView;
        
    }
    
    private void dfs(TreeNode root, int level){
        
        // NRL operations performed in the order
        
        // empty node : Do nothing
        if (root == null){
            return;
        }
        
        //  If the size is matching, add it . The elements in the rightView will be matching with the levels traversed 
        if (rightView.size() == level){
            rightView.add(root.val);
        }
        
        // Traverse right first for right tree
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);

    }
}