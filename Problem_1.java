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
//  * if(i==0) -- left size view


// 199. Binary Tree Right Side View
// Time Complexity : O(N)
// Space Complexity : O(h), height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// BFS Solution
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null ) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if(i == size-1){            //*
                    result.add(curr.val);
                }
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        return result;
    }
}


// Time Complexity : O(N)
// Space Complexity : O(h), height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// DFS Solution
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root,int level){
        if(root == null) return ;
        if(result.size() == level){
            result.add(root.val);
        }
        else {
            result.set(level,root.val);
        }
        dfs(root.left,level+1);
        dfs(root.right, level+1);
    }
}
