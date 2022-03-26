// Time Complexity : O(n) n is the number of nodes in the tree
// Space Complexity : O(h) h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Define variables for levels and parents of both x and y
//Now we can do preorder traversal with level and parents in the parameters
//When we encounter x or y we can update their respective variables for level and parent
//Now we will check if the nodes level are same and parents are different to determine if they are cousin.
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
    int xLev, yLev;
    TreeNode xParen, yParen;
    int x, y;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        findCousins(root, null, 0);
        return xLev == yLev && xParen != yParen;
    }
    private void findCousins(TreeNode root, TreeNode paren, int level){
        if(root == null){
            return;
        }
        if(root.val == x){
            xLev = level;
            xParen = paren;
        }
        if(root.val == y){
            yLev = level;
            yParen = paren;
        }
        findCousins(root.left, root, level+1);
        findCousins(root.right, root, level+1);
    }
}