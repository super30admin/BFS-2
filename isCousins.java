//Time Complexity: O(N)
//Space Complexity:  O(H) where H is Height of tree

//Idea is to perform a DFS and check for these 2 conditions 
//They should be on the same level - x_lvl == y_lvl
//There parents should be different - x_parent != y_parent

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
    int x_lvl, y_lvl;
    int x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return true;
        dfs(root, null, 0, x,y);
        return x_lvl == y_lvl && x_parent != y_parent;
    }

    private void dfs(TreeNode root, TreeNode parent, int lvl, int x, int y){
        if(root == null)
            return;
        if(root.val == x){
            x_lvl = lvl;
            if(parent!=null)
            x_parent = parent.val;
        }
        if(root.val == y){
            y_lvl = lvl;
            if(parent !=null)
            y_parent = parent.val;
        }
        dfs(root.left, root, lvl+1, x, y);
        dfs(root.right, root, lvl+1, x, y);
    }
} 