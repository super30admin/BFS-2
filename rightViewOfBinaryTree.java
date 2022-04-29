/**
Problem: https://leetcode.com/problems/binary-tree-right-side-view/
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

/**
Approach 1: BFS
TC: O(n)
SC: O(n)
*/
class Solution {
    List<Integer> res = null;
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            boolean addedRightMostNodeOfLevel = false;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                
                if (!addedRightMostNodeOfLevel) {
                    addedRightMostNodeOfLevel = true;
                    res.add(node.val);
                }
                
                if (node.right != null) {
                    queue.add(node.right);
                }
                
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        
        return res;
    }
}

/**
Approach 2: DFS
TC: O(n)
SC: O(1)
*/
class Solution {
    List<Integer> res = null;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        res = new ArrayList<>();
        
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int height) {
        if (root == null) return;
        
        if (height == res.size()) {
            res.add(root.val);
        }
        helper(root.right, height + 1);
        helper(root.left, height + 1);
    }
}