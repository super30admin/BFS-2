/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class BSTrightSideView {
    // TC: O(D) where D is depth of tree
    // SC: O(H)
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if (root == null)
            return result;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        if (result.size() == level) {
            result.add(root.val);

        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}