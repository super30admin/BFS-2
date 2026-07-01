import java.util.*;

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
    /*
        TC - O(N)
        SC - O(h) - recursion stack used is equal to height of tree
        This solution uses DFS (preorder traversal) to find the right side view of the binary tree.
        Starting from the root, it visits each node and keeps track of its level.
        If a level is visited for the first time, the node's value is added to the result.
        If another node is found at the same level, its value replaces the previous one.
        Since the traversal visits the left child before the right child, the rightmost node at each level 
        is visited last and overwrites the previous value. After the traversal is complete, the result 
        contains the value of the rightmost node at every level, which is the tree's right side view.
    */

    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        
        if (root == null) return result;
        helper(root, 0);

        return result;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == result.size()) {
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}