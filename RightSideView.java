// Time Complexity : O(n) where n is total no of nodes
// Space Complexity : O(h) for recursive stack(dfs) which at most stores the height of the tree;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.

import java.util.*;

class RightSideView {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level){
        if(root==null) return;
        if(level == result.size()){
            result.add(root.val);
        }
        //Adding only when a particular right side element of a level is not added to result

        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}

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