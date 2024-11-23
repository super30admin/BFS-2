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
// Approach : DFS - Recursion
// Time : O(n) 
// Space : O(n) // Height of  Recursive Stack
class Solution {
    int x_level , y_level;
    TreeNode x_parent , y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        this.x_parent = null;
        this.y_parent = null;
        this.x_level = -1;
        this.y_level = -1;
        dfs(root,x,y,0,null);
        return x_level == y_level && x_parent != y_parent;
    }

    private void dfs(TreeNode root,int x,int y,int depth, TreeNode parent){
        // Base case
        if(root == null) return;

        // Logic
        if(root.val == x){
            // identified x
            x_parent = parent;
            x_level = depth;
        }

        if(root.val == y){
            // identified y
            y_parent = parent;
            y_level = depth;
        }

        // recursion
        dfs(root.left,x,y,depth+1,root);
        dfs(root.right,x,y,depth+1,root);
    }
}


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
// Approach :BFS - Level Order traversal using one queue to process.
// Time : O(n) 
// Space : O(n/2) // width of  queues
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
      if (root == null) return false;
      Queue<TreeNode> q = new LinkedList<>();

      // Initally add root to the queue
      q.add(root);

      boolean x_found =false;
      boolean y_found = false;

      while(!q.isEmpty()){
        int level = q.size();
        for(int i =0;i<level;i++){
            TreeNode curr = q.poll();

            if(curr.val == x){
                x_found = true;
            } 

            if(curr.val == y){
                y_found = true;
            }

            // Before Adding nodes to the queue check if they are x and y
            // then they have same parents at the same depth
            if(curr.left!=null && curr.right!=null){
                if(curr.left.val == x && curr.right.val ==y) return false;
                if(curr.left.val == y && curr.right.val ==x) return false;
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
      return true;
    }
}