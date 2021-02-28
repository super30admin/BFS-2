/**
dfs/bfs: T: O(n)
S: O(depth) - dfs recursive stack
S: O(breadth) - bfs queue
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
    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth; int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, null, 0, x, y);
        return x_parent != y_parent && x_depth == y_depth;
    }
    
    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y){
        //base case
        if(root == null) return;
        //logic
        if(root.val == x){
            x_parent = parent;
            x_depth = depth;
        }
        else if(root.val == y){
            y_parent = parent;
            y_depth = depth;
        }
        
        dfs(root.left, root, depth+1, x, y);
        dfs(root.right, root, depth+1, x, y);
    }

    public boolean isCousinsBFS(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i< size; i++){
                TreeNode front = q.poll();
                if(front.val == x) x_found = true;
                if(front.val == y) y_found = true;
                
                if(front.left != null && front.right != null){
                    if(front.left.val == x && front.right.val == y) return false;
                    if(front.left.val == y && front.right.val == x) return false;
                }
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
        return false;
    }
}