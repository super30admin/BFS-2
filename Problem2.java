// Time Complexity :O(n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

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
//logic is in BFS solution, while adding the children check the childrens are x and y then return false cause they belong to same parent. And checking at each level whether we found both x and y, if we only find one element then return false cause the other might be in other level which doesnt make them cousins.
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean x_found = false;
        boolean y_found = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val==x)x_found =true;
                if(curr.val==y)y_found =true;
                //if both children are from same parent then not cousins
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y)return false;
                    if(curr.left.val==y && curr.right.val==x)return false;
                }
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(x_found==true && y_found==true)return true;
            if(x_found==true || y_found==true)return false;
        }
        return true;
    }
}