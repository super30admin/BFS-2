import java.util.*;

class Solution {
    // BFS solution without storing parent
    // Time complexity is O(n)
    // Space complexity is O(n)
    // This solution is submitted on leetcode with zero errors
    public class TreeNode {
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
    public boolean isCousins(TreeNode root, int x, int y) {
        //Edge case
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                if(x==node.val) x_found = true;
                if(y==node.val) y_found = true;
                // One step ahead only we check for parent before pushing
                if(node.left!=null && node.left.val == x && node.right!=null && node.right.val==y)
                    return false;
                if(node.left!=null && node.left.val == y && node.right!=null && node.right.val==x)
                    return false;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            if(x_found && y_found) return true;
        }
        return false;
    }
}