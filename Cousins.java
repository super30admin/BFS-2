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
 /**
 This Java solution checks if two nodes in a binary tree are cousins:

Perform a depth-first search (dfs) to find the depth and parent of nodes with values x and y.
Return true if the nodes are at the same depth and have different parents, indicating they are cousins.
The result is based on the conditions x_parent != y_parent and x_depth == y_depth.
Time Complexity: O(N) - where N is the number of nodes in the binary tree, as each node is processed once.
Space Complexity: O(H) - where H is the height of the binary tree. The space used by the recursive call stack is proportional to the height of the tree.
 In the worst case, the height is O(N), making the space complexity O(N).
  */
  class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, x, y, 0, null);

        return x_parent!= y_parent && x_depth == y_depth;

        
    }
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null) return;
       
        if(root.val == x){
           
            x_parent = parent;
            x_depth = depth;
        }
        if(root.val == y){
            
            y_parent = parent;
            y_depth = depth;
        }
        if(root.left != null) dfs(root.left, x, y, depth+1, root);
        if(root.right != null) dfs(root.right, x, y, depth+1, root);
    }
}