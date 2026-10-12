//Time Complexity : O(n)
//space Complexity : O(h)

public class CousinsBinaryTree {
    int x_depth;
    int y_depth;
    boolean flag;
    public boolean isCousins(TreeNode root, int x, int y) {
        flag = true;
        helper(root, x, y, 0);
        if(x_depth == y_depth) {
            if(flag) return true;
        }
        return false;
    }

    private void helper(TreeNode root, int x, int y, int depth) {

        if(root == null) return;

        if(root.left!=null && root.left.val == x && root.right!=null && root.right.val == y) {
            flag = false;
        }

        if(root.left!=null && root.left.val == y && root.right!=null && root.right.val == x) {
            flag = false;
        }

        if(root.val == x) {
            x_depth = depth;
        }

        if(root.val == y) {
            y_depth = depth;
        }

        helper(root.left, x, y, depth+1);
        helper(root.right, x, y, depth+1);

    }
}
