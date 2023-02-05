/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// 993. Cousins in Binary Tree
// Time Complexity : O(N)
// Space Complexity : O(N/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// BFS Solution
// Approach
// before putting inside the queue, check both the nodes belong to same parents or different parents

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x)
                    x_found = true;
                if(curr.val == y)
                    y_found = true;
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y)
                        return false;
                    if(curr.left.val == y && curr.right.val == x)
                        return false;
                }
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            if(x_found && y_found)
                return true;
            if(x_found || y_found)
                return false;
        }
        return false;
    }
}





// Time Complexity : O(N)
// Space Complexity : O(H), height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// DFS Solution

class Solution {
    static TreeNode x_parent;
    static TreeNode y_parent;
    static int xdepth;
    static int ydepth;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root,x,y,0,null);
        return x_parent != y_parent && xdepth == ydepth;
    }

    private static void dfs(TreeNode root,int x,int y,int depth,TreeNode parent){
        if(root == null) return;
        if(root.val == x){
            x_parent = parent;
            xdepth = depth;
        }
        if(root.val == y){
            y_parent = parent;
            ydepth = depth;
        }
        dfs(root.left,x,y,depth+1,root);
        dfs(root.right,x,y,depth+1,root);
    }

}

