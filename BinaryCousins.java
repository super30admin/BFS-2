
import java.util.*;

import javax.swing.tree.TreeNode;

// Time Complexity : O(N) for DFS and BFS
// Space Complexity : O(1) for DFS,O(N) for BFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class BinaryCousins {
    TreeNode x_parent = null,y_parent = null;
    int x_depth = -1,y_depth = -2;
    public boolean isCousins(TreeNode root,int x,int y){
        dfs(root,null,0,x,y);
        return x_parent != y_parent && x_depth == y_depth;
        return  bsf(root,x,y);
    }

    public void dfs(TreeNode root,TreeNode parent,int depth, int x,int y){

        if(root == null)
            return;
        if(root.val == x){
            x_depth = depth;
            x_parent = parent;
        }
        if(root.val == y){
            y_depth = depth;
            y_parent = parent; 
        }
        dfs(root.left,root,depth + 1,x,y);
        dfs(root.right,root,depth  + 1,x,y);
    }

    public boolean bfs(TreeNode root,int x,int y){
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean x_found = false,y_found = false;
            for(int i =0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.val == x){
                    x_found = true;
                }
                if(node.val == y){
                    y_found = true;
                }
                //Check for lead node
                if(node.left != null && node.right != null){
                    if(node.left.val == x && node.right.val == y){
                        return false;
                    }
                    if(node.left.val == y && node.right.val == x){
                        return false;
                    }
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(x_found && y_found)  
                return true;

        }
        return false;
    }
}