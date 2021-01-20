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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false; 
                    if(curr.left.val == y && curr.right.val == x) return false; 
                }
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(xFound && yFound) return true;
            if(xFound || yFound) return false; 
        }
        return false;
    }
}



/*
Cousins = different parents, but same depth. 
Equal depth does not mean cousins. 
Space big O(N);
*/