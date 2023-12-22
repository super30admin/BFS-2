//T.C O(n)
//S.C O(h)//worst case h=n
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

//DFS approach to recursively search for x and y and calc their depth and parent
class CousinsInTree {
    int x_depth = -1, y_depth = -1;
    TreeNode x_parent=null, y_parent=null;
    int first,sec;
    public boolean isCousins(TreeNode root, int x, int y) {
        first = x;
        sec = y;
        helper(root, 0,null);
        return x_depth == y_depth && x_parent != y_parent;
    }
    public void helper(TreeNode root,int depth, TreeNode parent){
        //base
        if(root==null) return;
        if(x_depth>0 && y_depth>0) return;
        if(root.val==first){
            x_depth = depth;
            x_parent = parent;
        }
        if(root.val==sec){
            y_depth = depth;
            y_parent = parent;
        }
        //logic
        helper(root.left,depth+1, root);
        helper(root.right, depth+1, root);
    }
}