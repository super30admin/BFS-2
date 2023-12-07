// Time Complexity : O(N) dfs, bfs
// Space Complexity : O(H) worsst O(N) dfs, O(N) dfs
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yes, both solutions were not very intuitive, took some time to understand

// Explain your approach: using dfs, at every node, track root, level, parent, assign parent and depth if root.val is x or y
// in every recursive call, root becomes parent and depth++

// Using bfs: keep track at every level if x is found and if y is found, if at a level both found return true
// check if curr val is x or curr val is y
// if at a level only one of x and y found return false
// if left and right or right and left children of root are x and y, return false
// advance curr, put left a dn right children in queue


public class prob2 {

    public class TreeNode {
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

    TreeNode x_parent; TreeNode y_parent; int x_depth; int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, x, y, 0, null);
        return x_parent != y_parent && x_depth == y_depth;
    }

    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null) return;
        dfs(root.left, x, y, depth+1, root);
        if(root.val == x){
            x_parent = parent;
            x_depth = depth;
        }
        if(root.val == y){
            y_parent = parent;
            y_depth = depth;
        }
        
        dfs(root.right, x, y, depth+1, root);
    }
    
}

/*class Solution {

    public class TreeNode {
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
            if(curr.val == x) x_found = true;
            if(curr.val == y) y_found = true;
            if(curr.left != null && curr.right != null){
              if(curr.left.val == x && curr.right.val == y) return false;
              if(curr.left.val == y && curr.right.val == x) return false;
            }
            if(curr.left != null ) q.add(curr.left);
            if(curr.right != null ) q.add(curr.right);
          }
          if(x_found && y_found) return true;
          if(x_found || y_found) return false;
        }
        return false;
        
    }
}*/
