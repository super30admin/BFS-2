//time : O(N)
//Space : O(N)

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root , int level)
    {
        if(root == null)
            return;
            if(result.size()==level)
                result.add(root.val);
                else
                result.set(level,root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}