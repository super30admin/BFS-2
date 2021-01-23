import java.util.LinkedList;
import java.util.Queue;
import com.util.customlist.TreeNode;

public class CousinsInBinaryTree {
	// Time Complexity : O(n)
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : No
	// Your code here along with comments explaining your approach
	/*
	 * This approach is by using BFS method where the traversal will happen level by level.
	 * Here, before reaching to the current node's child level, in the parent level itself is checked whether its left node and right node contains x and y values;
	 * which simply means those values found under the same parent node are not cousins but siblings and it will be returning false.
	 * 
	 */
	
	//BFS
	public boolean isCousinsBFS(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x) x_found = true;
                if(curr.val == y) y_found = true;
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
        return false;
    }
	
	// Time Complexity : O(n)
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : No
	// Your code here along with comments explaining your approach
	/*
	 * This approach is by using DFS method where the recursive stack is run under the hood.
	 * Here, if the parent node of both x and y are not the same and its heights are same then it can be said that x and y are cousins.
	 */
	
	//DFS
    TreeNode x_parent; TreeNode y_parent;
    int x_height; int y_height;
    public boolean isCousinsDFS(TreeNode root, int x, int y) {
        dfs(root, 0, null, x, y);
        return x_parent != y_parent && x_height == y_height;
    }
    
    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y){
        //base
        if(root == null) return;
        //logic
        if(root.val == x){
            x_parent = parent;
            x_height = level;
        }
        if(root.val == y){
            y_parent = parent;
            y_height = level;
        }
        dfs(root.left, level + 1, root, x, y);
        dfs(root.right, level + 1, root, x, y);
    }
}
