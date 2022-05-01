// Time Complexity : O(n), where n is the number of nodes
// Space Complexity : O(n) n is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root ==null)
            return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root==null)
            return;
        if(result.size()==level)
            result.add(root.val);
        if(result.size()>level)
            result.set(level,root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        return;
    }
}