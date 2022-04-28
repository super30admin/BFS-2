import com.sun.source.tree.Tree;

public class Cousins {

    // DFS approach
    // TC: O(n) n - number of nodes in a tree. We will be touching all the nodes in the worst case.
    // SC: O(h) h - maximal depth of a tree.
    int x_level, y_level;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, 0, null, x,y);
        return x_level == y_level && x_parent.val != y_parent.val;
    }

    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y) {
        if(root == null) return;

        if(root.val == x){
            x_level = level;
            x_parent = parent;
        }
        if(root.val == y){
            y_level = level;
            y_parent = parent;
        }

        // This will avoid unnecessary tree traversal if we already found x_parent and y_parent
        if(x_parent == null || y_parent == null) {
            dfs(root.left, level + 1, root,x,y);
            dfs(root.right, level + 1, root,x,y);
        }

    }
}
