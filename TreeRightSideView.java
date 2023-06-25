// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//  Definition for a binary tree node.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    //DFS
    // O(n) time, O(h) space
    //  public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> result = new ArrayList<>();
    //     dfs(root,0,result);
    //     return result;
    // }

    // private void dfs(TreeNode root, int level, List<Integer> result){
    //     if(root==null) return;
    //     if(result.size()==level){
    //         result.add(root.val);
    //     }
    //     dfs(root.right,level+1,result);
    //     dfs(root.left,level+1,result);
    // }
    //BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(list.get(list.size() - 1));
        }
        return result;
    }
}