// 993 Cousins in Binary Tree
// solved on leetcode
// Time Complexity - O(n)
// Space Complexity - O(n)


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
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean leftFound = false;
            boolean rightFound=false;
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                
                if(curr.right!=null && curr.left!=null){
                         if(curr.right.val==x && curr.left.val==y){
                              return false;
                          }
                         if(curr.left.val==x && curr.right.val==y){
                              return false;
                           }
                }
                
                if(curr.val==x){
                    leftFound=true;
                }
                if(curr.val==y){
                    rightFound=true;
                }
                
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
             if(rightFound==true && leftFound==true){
            return true;
            }
        }
        return false;
       
    }
}