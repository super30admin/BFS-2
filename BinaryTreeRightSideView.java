// Time Complexity : O(n) where n = number of elements in the tree
// Space Complexity : O(n) where n = width of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//199. Binary Tree Right Side View (Medium) - https://leetcode.com/problems/binary-tree-right-side-view/
class Solution {
    
    List<Integer> result;
        
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        
        if (root == null) return result;
        
        result.add(root.val);
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        // base
        if (root == null) return;
        
        // logic
        if (level == result.size()) {
            result.add(root.val);
        }
        
        // recurse through right first and then left as we are adding right most elements
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}