// Time Complexity : O(n)
// Space Complexity : O(n) - BFS solution, O(h) - DFS solution
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class Cousins_In_A_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode x_parent; TreeNode y_parent;
    int x_height; int y_height;

    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null) return false;

        dfs_helper(root, x, y, 0 , null);
        return x_height == y_height && x_parent != y_parent;
    }

    private void dfs_helper(TreeNode root, int x, int y, int height, TreeNode parent){

        //base
        if(root == null) return;
        //logic
        if(root.val == x){
            x_parent = parent;
            x_height = height;
        }
        if(root.val == y){
            y_parent = parent;
            y_height = height;
        }
        dfs_helper(root.left, x, y, height + 1, root);
        dfs_helper(root.right, x, y, height + 1, root);
    }

    public boolean isCousinsUsingBFS(TreeNode root, int x, int y) {
        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false; boolean y_found = false;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x) x_found = true;
                if(curr.val == y) y_found = true;

                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.right.val == x && curr.left.val == y) return false;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t9 = new TreeNode(9, t5, t1);
        TreeNode t0 = new TreeNode(0, null, null);
        TreeNode t4 = new TreeNode(4, t9, t0);

        System.out.println("Are given nodes cousins? : " + new Cousins_In_A_Tree().isCousins(t4, 4, 9));
        System.out.println("Are given nodes cousins? : " + new Cousins_In_A_Tree().isCousinsUsingBFS(t4, 4, 9));
    }
    
}
