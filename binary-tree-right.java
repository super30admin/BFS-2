//Time Complexity: O(n)
//Space Complexity:o(n)
//Did this code successfully run on Leetcode :Yes
class Solution {
    private List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        // edge
        if (root == null)
            return;
        int size = result.size();
        if (level == size) {
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }

        // logic
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}