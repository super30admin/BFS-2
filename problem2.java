//993. Cousins in Binary Tree
//Time Complexity: O(n)
//Space Complexity: O(n)

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
    int currDepth = -1;
    boolean isCousin = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,0,x,y);
        return isCousin;
    }

    private boolean helper(TreeNode node, int depth, int x, int y){
        if (node==null) return false;

        if(currDepth !=-1 && depth>currDepth) return false;

        if(node.val == x || node.val ==y){
            if(currDepth == -1){
                currDepth = depth;
            }
            return currDepth == depth; 
        }

        boolean left = helper(node.left, depth+1,x,y);
        boolean right = helper(node.right,depth+1,x,y);

        if(left && right && currDepth!= depth+1){
            isCousin = true;
        }
        return left || right;
    }
}