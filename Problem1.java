// Time Complexity :O(n) 
// Space Complexity :O(h)
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
//logic is dfs with recurssion on left and replace the contents when we reach right
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root==null)return result;
        dfs(root,0);
        return result;
    }
    public void dfs(TreeNode root, int level){
        //base condtion when to stop
        if(root==null)return ;
        //if the size and level are equal add to root
        if(result.size()==level){
            result.add(root.val);
        }
        //replace the contents when we reach next element at same level
        else{
            result.set(level,root.val);
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    } 
}