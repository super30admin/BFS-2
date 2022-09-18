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

//TC: O(n)
//SC: O(n)
class Solution {
    // List <>
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val==x ||root.val==y ) return false;


        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size= q.size();
            boolean x_height= false, y_height= false;

            for(int i=0;i<size;i++){
                TreeNode curr= q.poll();

                if(curr.val==x) x_height=true;
                if(curr.val==y) y_height=true;
                if(curr.left!=null && curr.right!=null)
                {
                    if(curr.left.val==x && curr.right.val==y) return false;
                    if(curr.left.val==y && curr.right.val==x) return false;
                }


                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(x_height==true && y_height==true) return true;
        }
        return false;
    }
}