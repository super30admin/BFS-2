
// Time Complexity : O(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    //aesha
    //dfs
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
         this.result = new ArrayList<>();
         dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level)
    {
        if(root== null) return;
        if(result.size()==level)
        {
            result.add(root.val);
        }
        else{
            result.set(level, root.val);
        }

        dfs(root.left, level+1);
        dfs(root.right,level+1);
    }
}