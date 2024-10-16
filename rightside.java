class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();

        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root, int level){
        if(root==null) return;

        if(res.size()==level){
            res.add(root.val);
        }
        dfs(root.right,level+1);
        dfs(root.left, level+1);
    }
}
