
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

// DFS -
// Time complexity = O(n)// iterate over all the nodes.
// Space complexity = O(h), where h is the height. max h = n , min h = log(n)
// we essentially use the level to limit what is added in the res list.

// res is a reference, so it does not matter if I keep it as a global variable or local variable.

import java.util.ArrayList;
import java.util.List;
class RightSideDFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,0, res);
        return res;
        
    }
    
    private void helper(TreeNode root, int level, List<Integer> res ) {
        if(root==null) {
            return;
        }
        if(res.size() == level) {
            res.add(root.val);
        } else {
            res.set(level, root.val);
        }
        helper(root.left,level+1, res);
        helper(root.right,level+1, res);
        return;
    }
}