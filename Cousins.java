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
// Time Complexity : O(n)
// Space Complexity : O(h)

// Determines if two nodes in a binary tree are cousins.
// Uses DFS to record depths and parents of both nodes, then compares them.

class Solution {
    int xDepth = -1;
    int yDepth = -1;
    TreeNode xParent = null, yParent = null;

    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root,null,0,x,y);

        return (xDepth == yDepth) && (xParent!=yParent);
        
    }

    public void dfs(TreeNode root, TreeNode parent , int height, int x, int y){
        
        //base case 
        if(root == null){
            return;
        }

        //logic
        if(root.val == x){
            xDepth = height;
            xParent = parent;
        }
        if(root.val == y){
            yDepth = height;
            yParent = parent;
        }

        if(xParent!=null && yParent!=null) return;

        dfs(root.left,root, height+1,x,y);
        dfs(root.right,root, height+1,x,y);
    }
}