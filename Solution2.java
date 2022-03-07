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
/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
class Solution {
    
    public class Pair{
        int parent;
        int level;
        
        Pair(int parent, int level){
            this.parent = parent;
            this.level = level;
        }
    }
    
    Pair x_pair = null;
    Pair y_pair = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0, null);
        if(x_pair.parent!=y_pair.parent && x_pair.level == y_pair.level){
            return true;
        }
        
        return false;
    }
    
    public void helper(TreeNode node, int x, int y, int depth, TreeNode prev){
        if(node==null){
            return;
        }
        
        if(node.val == x && x_pair==null){
            if(prev==null){
                x_pair = new Pair(-1, depth);
            }else{
                x_pair = new Pair(prev.val, depth);
            }
        }
        
        if(node.val == y && y_pair==null){
           if(prev==null){
                y_pair = new Pair(-1, depth);
            }else{
                y_pair = new Pair(prev.val, depth);
            }
        }
        
        prev = node;
        helper(node.left, x, y, depth + 1, prev);
        helper(node.right, x, y, depth + 1, prev);
        
        return;
        
    }
}
