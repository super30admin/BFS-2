public class SymetricTree /**
 Do dfs on left and right tree. Check if the calues are symentric.

 */
class Solution {
    boolean flag;

    public boolean isSymmetric(TreeNode root) {
        flag = true;
        dfs(root.left, root.right);
        return flag;
    }

    private void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return;
        }
        if (left == null || right == null || left.val != right.val) {
            flag = false;
            return;
        }
        dfs(left.left, right.right);
        if (flag) dfs(left.right, right.left);
    }
}{
}
