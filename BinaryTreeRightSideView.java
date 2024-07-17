// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    List<Integer> li;

    public List<Integer> rightSideView(TreeNode root) {
        this.li = new ArrayList<>();
        dfs(root, 0);
        return li;
    }

    private void dfs(TreeNode root, int level) {
        // base
        if (root == null)
            return;
        // logic
        if (level == li.size())
            li.add(root.val);

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}