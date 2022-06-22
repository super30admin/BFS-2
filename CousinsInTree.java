//Time Complexity: O(n)
//Space Complexity: O(h) for stack space, where h is height of the stack
public class CousinsInTree {
    private TreeNode x_parent;
    private TreeNode y_parent;
    int x_ht; int y_ht;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return true;
        dfs(root, null, 0, x, y);
        return x_parent != y_parent && x_ht == y_ht;
    }

    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        if(root == null) return;

        if(root.val == x){
            x_parent = parent;
            x_ht = level;
        }
        if(root.val == y){
            y_parent = parent;
            y_ht = level;
        }
        if(x_parent == null || y_parent == null)
            dfs(root.left, root, level+1, x, y);
        if(x_parent == null || y_parent == null)
            dfs(root.right, root, level+1, x, y);

    }
}
