class RightSideTree {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return result;
        }

        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }

        if(level == result.size()){
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
