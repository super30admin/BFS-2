// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Solution 1: Cousins in Binary Tree using BFS
// Time: O(n), Space: O(n/2)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i =0; i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val == x) x_found = true;
                if(curr.val == y) y_found = true;

                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }

            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }

        return false;
    }
}

//Solution 2: Using DFS , Time = O(n) , Space = O(h)
class Solution {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root,x, y, 0, null);
        return x_depth == y_depth && x_parent!=y_parent;
    }

    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent){

        //base
        if(root == null) return;

        //logic
        if(root.val == x){
            x_depth = level;
            x_parent = parent;
        }

        if(root.val == y){
            y_depth = level;
            y_parent = parent;
        }
        
        dfs(root.left, x, y, level+1, root);
        dfs(root.right,x, y, level+1, root);
    }
}