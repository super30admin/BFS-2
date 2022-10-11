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
    TreeNode parentX = null, parentY = null;
        
        int lvlx = 0, lvly = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null) return false;
        
        // Method - 1 BFS
        // TC : O(n)
        // SC : O(n)
        /*TreeNode parentX = null, parentY = null;
        
        int lvl=0, lvlx = 0, lvly = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if(temp.left != null) {
                    if(temp.left.val == x) {
                    parentX = temp;
                    lvlx = lvl;
                    }
                    if(temp.left.val == y) {
                    parentY = temp;
                    lvly = lvl;
                    }
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    if(temp.right.val == x) {
                    parentX = temp;
                    lvlx = lvl;
                    }
                    if(temp.right.val == y) {
                    parentY = temp;
                    lvly = lvl;
                    }
                    q.add(temp.right);
                }
            }
            lvl++;
        }*/
        helper(null,root, 0, x, y);
        if(lvlx != 0 && lvly != 0 
           && lvlx == lvly 
           && parentX != null && parentY != null
           && parentX != parentY)
            return true;
        
        return false;
    }
    
    // Method - 2 DFS
        // TC : O(n)
        // SC : O(h)
    
    private void helper(TreeNode parent, TreeNode root, int lvl, int x, int y) {
        if(root == null) return;
        
        if(root.val == x) {
            lvlx = lvl;
            parentX = parent;
            return;
        }
        
        if(root.val == y) {
            lvly = lvl;
            parentY = parent;
            return;
        }
        
        helper(root, root.left, lvl+1, x, y);
        helper(root, root.right, lvl+1, x, y);
    }
}
