// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class CousinsInBinaryTreeDFS {
    int x_level, y_level;
    TreeNode x_parent, y_parent;

    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root, null, 0, x, y);
        return x_parent != y_parent && x_level == y_level;
    }

    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){

        if(root == null){
            return;
        }

        if(root.val == x){
            x_level = level;
            x_parent = parent;
        }

        if(root.val == y){
            y_level = level;
            y_parent = parent;
        }

        dfs(root.left, root, level + 1, x, y);
        dfs(root.right, root, level + 1, x, y);


    }
}
