// Time Complexity : O(n) n is the number of nodes
// Space Complexity : O(h) h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Traverse tree in node - right - left order. We will also pass the level int the dfs traversal
//When there is no element in the result list at a particular level and we encounter a 
//node that belongs to that level, we will add to the list.

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
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        rsv(root, 0);
        return res;
    }
    private void rsv(TreeNode node, int level){
        if(node == null)
            return;
        if(level == res.size()){
            res.add(node.val);
        }
        rsv(node.right, level+1);
        rsv(node.left, level+1);
    }
}