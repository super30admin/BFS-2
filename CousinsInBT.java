/* Tc: O(n) n:no. nodes in the tree. 
 *  SC: O(n) n:no. nodes in the tree. 
 *  Approach: Perform BSt and on each level i will keep track of two flags each for the the number to be searched.If number is found then flag will be updated associatred with the number. Also before adding the node to the queue i will check if both the children of the root is not x and y,
 *  if it is then i will retunr false right away.
 * After the end of each level i will check the flag and return accordingly. if nothing is found then return false at the end.
 */

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

        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
  
        while(!q.isEmpty()){
            int len = q.size();
            boolean xExist = false, yExist = false;

            for(int i = 0 ; i< len; i++){
                TreeNode curr = q.poll();

                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.val == x) xExist = true;
                if(curr.val == y) yExist = true;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
           if(xExist && yExist) return true;
           if(xExist || yExist) return false;
        }
     return false;   
    }
}