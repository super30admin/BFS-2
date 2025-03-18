// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean xFound = false;
        boolean yFound = false;
        TreeNode xParent = null;
         TreeNode yParent = null;


        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
             xFound = false;
             yFound = false;
             xParent = null;
             yParent = null;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if(curr.left != null && curr.left.val == x){
                    xFound = true;
                    xParent = curr;
                }else if(curr.left != null && curr.left.val == y){
                    yFound = true;
                    yParent = curr;
                }

                if(curr.right != null && curr.right.val == x){
                    xFound = true;
                    xParent = curr;
                }else if(curr.right != null && curr.right.val == y){
                    yFound = true;
                    yParent = curr;
                }

                if(xFound && yFound && xParent != yParent){
                    return true;
                }else{
                    if(curr.left != null){
                        q.add(curr.left);
                    }

                    if(curr.right != null){
                        q.add(curr.right);
                    }


                }
            }

        }

        return false;
        
    }
}