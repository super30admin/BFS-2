package BFS2;

// Time Complexity : O(n)
// Space Complexity : O(h)   //h is the height of the tree;
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeRightSideViewWithRecursion {
      List<Integer> result;
        public List<Integer> rightSideView(TreeNode root) {
            this.result = new ArrayList<>();
            helper(root,0);
            return result;

        }
      public void helper(TreeNode root, int level)
        {
            if(root == null) return;
            if(level == result.size())
            {
                result.add(root.val);
            }
            level++;
            helper(root.right, level);
            helper(root.left, level);
        }
    }
