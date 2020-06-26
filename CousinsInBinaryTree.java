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
// Time Complexity : O(n)  n: all nodes;  when cousins are present in leaf level.
// Space Complexity : O(n)  max no. of nodes at any level.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Use bfs method through recursion and traverse till all the connected 1's are covered.
 */
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int flagx = 0;
            int flagy = 0;
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                int left=0; int right=0;
                if(curr.left!=null){
                   left  = curr.left.val;
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    right = curr.right.val;
                    q.add(curr.right);
                }
                    
                if(left == x && right == y) return false;
                if(right == x && left == y) return false;
                if(left == x || right == x) flagx = 1;
                if(left == y || right == y) flagy = 1;   
                
            }
            if(flagx == 1 && flagy == 1) return true;
            if(flagx == 1 || flagy == 1) return false;
        }
        return false;
    }
}