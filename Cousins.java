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
    public boolean isCousins(TreeNode root, int x, int y) {
        // condition 1: Parent not same
        // level should be same
        
        // maintain parent and level of x and y
        TreeNode parentX = null;
        TreeNode parentY = null;
        int level_X = -1;
        int level_Y = -1;
        
        if(root  == null)  return false;
        
        // if x and y are children of root return false
        
        Queue<TreeNode> q = new LinkedList();
        
        q.add(root);
        int currLevel = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode node = q.poll();
            
                if(node.left != null) {
                    if(node.left.val == x) {
                        parentX = node;
                        level_X = currLevel;
                    }
                    if(node.left.val == y) {
                        parentY = node;
                        level_Y = currLevel;
                    }
                    q.add(node.left);
                }
                if(node.right != null) {
                    if(node.right.val == x) {
                        parentX = node;
                        level_X = currLevel;
                    }
                    if(node.right.val == y) {
                        parentY = node;
                        level_Y = currLevel;
                    }
                    q.add(node.right);
                }
            }
            
            if(parentX != null && parentY != null) {
                break;
            }
            currLevel++;
            
        }
        
        if(parentX != parentY && level_X == level_Y) {
            return true;
        }
        return false;
        
    }
}
