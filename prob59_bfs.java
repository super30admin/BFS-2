// S30 Big N Problem #59 {Easy}
// 993. Cousins in Binary Tree
// Time Complexity :O(n) where n is the number of nodes in the binary tree
// Space Complexity :O(m) where m is the number of nodes at any level
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach
//BFS solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            boolean x_found=false;
            boolean y_found=false;
            for(int i=0;i<size;i++){
                //checking at each level
                TreeNode node=q.poll();
                if(node.val==x) x_found=true;
                if(node.val==y) y_found=true;
                
                if(node.left!=null && node.right!=null){
                    if(node.left.val==x && node.right.val==y) return false;
                    if(node.right.val==x && node.left.val==y) return false;
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            if(x_found && y_found) return true;
        }
        return false;
    }
}
