//TC: O(n)
//SC: O(1)

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
// DFS: only right

class RightSideView {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode node, int level) {
        if(node == null) return;
        if(level == result.size()) {
            result.add(node.val);
        }
        dfs(node.right, level + 1);
        dfs(node.left, level + 1);
    }
}

// DFS: left to right

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode node, int level) {
        if(node == null) return;
        if(level == result.size()) {
            result.add(node.val);
        }
        else{
            result.set(level, node.val);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}

//BFS:

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(i == size - 1){
                    result.add(curr.val);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return result;
    }
}