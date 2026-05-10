// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree stack space in case of skewed tree
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// We will do a depth first traversal and keep track of the level of the current node and the parent of the current node.
// We will check if the current node is equal to x or y and if it is we will store the level and the parent of the current node.
// After the traversal is done we will check if the level of x and y are the same and if the parent of x and y are different.
//  If both conditions are true then x and y are cousins and we will return true. Otherwise we  will return false.

// Your code here along with comments explaining your approach
import java.util.*;

/**
 * Definition for a binary tree node.
 * public class BinTreeRightSideBFS {
 *     int val;
 *     BinTreeRightSideBFS left;
 *     BinTreeRightSideBFS right;
 *
 *     BinTreeRightSideBFS() {}
 *
 *     BinTreeRightSideBFS(int val) {
 *         this.val = val;
 *     }
 *
 *     BinTreeRightSideBFS(int val, BinTreeRightSideBFS left, BinTreeRightSideBFS right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public List<Integer> rightSideView(BinTreeRightSideBFS root) {

        List<Integer> result = new ArrayList<>();

        helper(root, 0, result);

        return result;
    }

    public void helper(BinTreeRightSideBFS   root, int level, List<Integer> res) {

        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.val);
        }

        helper(root.right, level + 1, res);

        helper(root.left, level + 1, res);
    }
}