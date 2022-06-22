// https://leetcode.com/problems/binary-tree-right-side-view/submissions/

// Time Complexity: O(n)
// Space Complexity: O(h) // Recursive stack
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        // null case
        if(root == null) return result;
        
        //
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        // Base case
        if(root == null) return;
        
        // Logic
        if(level == result.size()) {
            result.add(root.val);    
        } else {
            result.set(level, root.val);
        }
        
        dfs(root.left, level + 1);
        
        dfs(root.right, level + 1);
    }
}