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

//BFS Solution
//Time Complexity: O(n) 
//Space Complexity: O(n^2) both nodes and their parents are in stack.
/*
 * here we store the node and its parent in two queues. and check if
 * the node is x or y save the value and check the parent are differnt.
 * return true else return false.
 */
class Solution {
    boolean x_found;
    boolean y_found;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q_parent = new LinkedList<>();
        q.add(root);
        q_parent.add(null);
        while(!q.isEmpty()){
            x_found = false;
            y_found = false;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                TreeNode curr_parent = q_parent.poll();
                if(x == curr.val){
                    x_parent = curr_parent;
                    x_found = true;
                }
                if(y == curr.val){
                    y_parent = curr_parent;
                    y_found = true;
                }
                if(curr.left != null) {
                    q.add(curr.left);
                    q_parent.add(curr);
                }
                if(curr.right != null ) {
                    q.add(curr.right);
                    q_parent.add(curr);
                }
            }
            if(x_found && y_found && x_parent != y_parent) return true;
        }
        return false;
    }
}