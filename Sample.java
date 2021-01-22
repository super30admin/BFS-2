https://leetcode.com/problems/cousins-in-binary-tree/
// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
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
        if(root==null) return false;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            boolean x_done=false, y_done=false;
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp.val==x) x_done = true;
                if(temp.val==y) y_done = true;
                if(temp.left!=null && temp.right!=null){
                    if((temp.left.val==x && temp.right.val==y) ||
                    (temp.left.val==y && temp.right.val==x)) return false;
                }
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);           
            }
            if(x_done == true && y_done == true) return true;
            if(x_done == true || y_done == true) return false;
            
            
        }
        return false;
    }
}