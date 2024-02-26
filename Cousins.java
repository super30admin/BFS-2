//DFS approach
// Time Complexity : O(n), going over all the nodes
// Space Complexity : O(h), recursive stack 
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : find each nodes parent and level in recursive stack. compare for both x & y 

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
class Solution {
    int x_depth;
    TreeNode x_parent;
    int y_depth;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,x,y,0,null);
        
        if(x_depth == y_depth && x_parent != y_parent){
            return true;
        }

        return false;
    }

    private void dfs(TreeNode root, int x , int y,int level, TreeNode parent){
        //base
        if(root == null) return;
        if(x_parent != null && y_parent != null) return;

        if(root.val == x){
            x_depth = level;
            x_parent = parent;
        }

        if(root.val == y){
            y_depth = level;
            y_parent = parent;
        }

        dfs(root.left,x,y,level+1,root);
        dfs(root.right,x,y,level+1,root);
    }
}

//BFS approach
// Time Complexity : O(n), going over all the nodes
// Space Complexity : O(n), there will be n/2 nodes in the queue at leaf level
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Insert root into the queue and check x and y are found on the same level.

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
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q= new LinkedList<>();
        Queue<TreeNode> pq = new LinkedList<>();

        q.add(root);
        pq.add(null);
        boolean x_found = false;
        boolean y_found = false;
        TreeNode x_parent = null;
        TreeNode y_parent = null;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size;i++){
                TreeNode curr = q.poll();
                TreeNode currP = pq.poll();

                if(x == curr.val){
                    x_found = true;
                    x_parent = currP;
                }

                if(y == curr.val){
                    y_found = true;
                    y_parent = currP;
                }

                if(curr.left != null){
                    q.add(curr.left);
                    pq.add(curr);
                }

                if(curr.right != null){
                    q.add(curr.right);
                    pq.add(curr);
                }
            }

            if(x_found && y_found && x_parent != y_parent) return true;
            if(x_found || y_found) return false;
        }

        return false;
    }
}