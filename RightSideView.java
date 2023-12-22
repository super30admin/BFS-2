//T.C O(n) - no. of nodes
//S.C O(h) - height of the tree
// Recursive approach : DFS: Recursively call the left and right subtrees and when depth of the tree is equal to size of result, add it to the result.

import java.util.ArrayList;
import java.util.List;

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
//DFS appraoch to traverse through all nodes and save in res list for each level.
//Each node will add itself to res list at that level index overwriting others of its level and so the last element
//to overwrite is the right side view
class RightSideView {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int level){
        if(root == null) return;

        if(level == res.size()) {
            res.add(root.val);
        }

        helper(root.right, level+1);
        helper(root.left, level+1);
    }
}