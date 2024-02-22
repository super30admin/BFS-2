// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

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
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        helperstartFromRight(root, 0);
        // helperstartFromLeft(root, 0);
        return result;
    }

    private void helperstartFromRight(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (result.size() == level) {
            result.add(root.val);
        }
   
        if (root.right != null) {
            helperstartFromRight(root.right, level + 1);
        }
        if (root.left != null) {
            helperstartFromRight(root.left, level + 1);
        }

    }

     private void helperstartFromLeft(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() != level) {
            result.set(level, root.val);
        } else {
            result.add(root.val);
        }
        
        if (root.left != null) {
            helperstartFromLeft(root.left, level + 1);
        }
        if (root.right != null) {
            helperstartFromLeft(root.right, level + 1);
        }
    }
}