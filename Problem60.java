Time Complexity : O(N) where N is the number of Nodes
Space Complexity : O(N)

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
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i<size; i++){
                TreeNode cur = q.poll();
                if(cur.val == x) x_found = true;
                if(cur.val == y) y_found = true;
                if(cur.left != null && cur.right!=null){
                    if((cur.left.val == x && cur.right.val == y) || (cur.left.val == y && cur.right.val == x)){
                        return false;
                    }
                }
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            if(x_found && y_found) return true;
        }
        return false;
    }
}

// DFS
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
    TreeNode x_parent;
    TreeNode y_parent;
    int x_level = 0;
    int y_level = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, 0, null, x, y);
        return (x_parent != y_parent && x_level == y_level);
    }
    
    private void dfs(TreeNode root, int level, TreeNode parent, int x , int y){
        if(root == null) return;
        if(root.val == x){
            x_parent = parent;
            x_level = level;
        }
        if(root.val == y){
            y_parent = parent;
            y_level = level;
        }
        dfs(root.left, level+1, root, x, y);
        dfs(root.right, level+1, root, x, y);
    }
}