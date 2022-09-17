// Problem2 - https://leetcode.com/problems/cousins-in-binary-tree/submissions/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

class BFS {
    public boolean isCousins(TreeNode root, int x, int y) {
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
            
        while(!q.isEmpty()){
            int size = q.size();
            boolean xStatus = false;
            boolean yStatus = false;
            for(int i=0; i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val == x) xStatus = true;
                if(curr.val == y) yStatus = true;
                
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val== x)return false;
                }
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);

            }
            if(xStatus && yStatus) return true;
            if(xStatus || yStatus) return false;
        }
        return false;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(h)
class DFS {
            TreeNode x_parent;
        TreeNode y_parent;
        int x_depth;
        int y_depth;
        public boolean isCousins(TreeNode root, int x, int y) {
            if(root == null) return false;
            dfs(root,x,y,0,null);
                return x_parent != y_parent && x_depth == y_depth;
        }
    
        private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
            //base
            if(root == null) return;
            
            //logic
            if(root.val == x){
                x_parent = parent;
                x_depth = depth;
            }
            
            if(root.val == y){
                y_parent = parent;
                y_depth = depth;
            }
            
            dfs(root.left, x,y, depth+1,root);
            dfs(root.right, x,y, depth+1,root);
        }
}