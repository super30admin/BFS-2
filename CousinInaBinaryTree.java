// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//identify if siblings then false or check if in same level then true.. if not b def false
import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
   }
 }

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int i = queue.size();
            boolean x_found=false;
            boolean y_found=false;
            while(i>0){
                TreeNode temp = queue.poll();
                if(temp!=null){
                    if(temp.left!=null && temp.right!=null && ((temp.left.val == x && temp.right.val==y) || (temp.left.val == y && temp.right.val==x)) ){
                        return false;
                    }
                    if((temp.left!=null && temp.left.val == x) || (temp.right!=null && temp.right.val==x)){
                        x_found=true;
                    }
                    if((temp.left!=null && temp.left.val == y) || (temp.right!=null && temp.right.val==y)){
                        y_found=true;
                    }
                    if(x_found && y_found){
                        return true;
                    }
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
                i--;
            }
        }
        return false;
    }
}