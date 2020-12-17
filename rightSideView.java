// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList();
        dfs(root, 0);
        
        return result;
    }
    public void dfs(TreeNode node, int lvl) {
        if(node == null)
            return;
        if(result.size() == lvl)
            result.add(node.val);
        dfs(node.right, lvl + 1);
        dfs(node.left, lvl + 1);
    }
}