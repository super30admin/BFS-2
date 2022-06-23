//Time Complexity: O(n)
//Space Complexity: O(h), h is the height of the tree for dfs for bfs O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No
//bfs
class Solution {
    
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_flag = false;
            boolean y_flag = false;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x) x_flag = true;
                if(curr.val == y) y_flag = true;
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(x_flag && y_flag) return true;
            if(x_flag || y_flag) return false;
        }
        return false;
    }
    
}


/* DFS
class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_ht;; int y_ht;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, null, 0, x,y);
        return x_parent != y_parent && x_ht == y_ht;
    }
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        //base
        if(root == null) return;
        //logic
        if(root.val == x){
            x_parent = parent;
            x_ht = level;
        }
        if(root.val == y){
            y_parent = parent;
            y_ht = level;
        }
        if(x_parent == null || y_parent == null)
            dfs(root.left, root, level + 1, x, y);
        if(x_parent == null || y_parent == null)
            dfs(root.right, root, level + 1, x, y);
    }
}
*/