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

//TC O(n)
// SC O(h)


class Solution {
     List<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null){
            return new ArrayList<>();
        }

        list = new ArrayList<>();
        dfs(root, 0);
        return list;
    }

    private void dfs(TreeNode root, int level){
        if(root == null){
            return ;
        }

        if(level == list.size()){
            list.add(root.val);
        }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
       
    }
}