// Time Complexity : O(n) where n is number of nodes in the input tree
// Space Complexity : O(h) where h is height of the binary tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
public class RightViewBinaryTree{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(root, res, 0);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res, int level){
        //base
        if(root == null){
            return;
        }
        
        // logic
        // since we are traversing right side of tree first if there is any value at the level, 
        // it means we already have the right most node in our resukt list
        if(level == res.size()){
            res.add(root.val);
        }
        dfs(root.right, res, level + 1);
        dfs(root.left, res, level + 1);
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
}