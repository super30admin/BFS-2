// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//199. Binary Tree Right Side View
//https://leetcode.com/problems/binary-tree-right-side-view/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    // BFS approach
    // time: O(n)
    // space: O(n)
    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null)
            return list;

        Queue<TreeNode> q = new LinkedList<>();
        int count = 1;
        q.add(root);
        int size = count;
        count = 0;
        while (!q.isEmpty()) {

            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    list.add(q.peek().val);
                }
                TreeNode temp = q.remove();
                if (temp.left != null) {
                    q.add(temp.left);
                    count++;
                }
                if (temp.right != null) {
                    q.add(temp.right);
                    count++;
                }
            }
            size = count;
            count = 0;

        }
        return list;
    }
}

/*
 * class Solution {
 * //DFS approach
 * //time:O(n)
 * //space:O(h) where h is height of the tree that the recursive stack reaches
 * List<Integer> list = new ArrayList<>();
 * public List<Integer> rightSideView(TreeNode root) {
 * 
 * if(root == null) return list;
 * 
 * helper(root, 0);
 * return list;
 * }
 * 
 * private void helper(TreeNode root, int level){
 * //base
 * if(root == null) return;
 * 
 * //logic
 * if(list.size() == level){
 * list.add(level, root.val);
 * }else{
 * list.set(level, root.val);
 * }
 * helper(root.left, level+1);
 * 
 * helper(root.right, level+1);
 * }
 * }
 */