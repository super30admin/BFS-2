class Solution1 {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == result.size())
            result.add(root.val);
        helper(root.right, level + 1);
        helper(root.left, level + 1);
    }
}