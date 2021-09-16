// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        // base
        if(root == null) return;
        
        // logic
        if(result.size() == level){
            result.add(root.val);
        }
        dfs(root.right, level+1);
        //st.pop()
        dfs(root.left, level+1);
    }
}