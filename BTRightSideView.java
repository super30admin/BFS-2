class Solution {
    private List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
            //null case
            if (root == null) return result;
            dfs(root, 0);
            return result;
    }
    private void dfs(TreeNode root, int level) {
            //base
            if(root==null) return;
            //logic
            if (result.size() == level) {
                result.add(root.val);
            }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
        }
}
