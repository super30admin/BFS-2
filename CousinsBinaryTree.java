// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        TreeNode check = null;
        Queue<TreeNode> que = new LinkedList<>();
        if(root!=null) que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            while(size>0){
                TreeNode temp = que.poll();
                if(temp.left!=null){
                    if(temp.left.val == x || temp.left.val == y){
                        if(check == null) check = temp;
                        else {
                            if(check != temp) return true;
                            else return false;
                        }
                    }
                    que.add(temp.left);
                }
                if(temp.right!=null){
                    if(temp.right.val == x || temp.right.val == y){
                        if(check == null) check = temp;
                        else {
                            if(check != temp) return true;
                            else return false;
                        }
                    }
                    que.add(temp.right);
                }
                size--;
            }
            if(check != null) return false;
        }
        return false;
    }
}
