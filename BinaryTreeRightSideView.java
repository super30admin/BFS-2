package BFS2;
// Time Complexity : O(n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes


import Trees1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int level){
        if(root == null)
            return;
        if(result.size() == level){
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }

        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}
