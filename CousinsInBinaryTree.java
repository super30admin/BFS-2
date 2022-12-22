import java.util.*;
//DFS solution
// Time Complexity: O(n)
//Space Complexity: O(n) // which is the height of the tree
/*
 * get the value of x and y from the tree and store thier parent as well
 * if the values are at same level and the parents are differnet then return
 * true else return false.
*/
public class CousinsInBinaryTree {
    private int x_level;
    private int y_level;
    private TreeNode x_parent;
    private TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return x_level == y_level && x_parent != y_parent;
    }
    public void dfs(TreeNode root, int x, int y, int level, TreeNode parent){
        //base
        if(root == null) return;

        //logic
        if(root.val == x){
            x_parent = parent;
            x_level = level;
        }
        if(root.val == y){
            y_parent = parent;
            y_level = level;
        } 
        dfs(root.left, x, y, level+1, root);
        dfs(root.right, x, y, level+1, root);
    }
}
