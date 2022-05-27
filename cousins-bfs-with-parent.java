import java.util.*;

class Solution {
    // BFS solution with storing parent
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
        Queue<TreeNode> qp = new LinkedList<>();
        q.add(root);
        qp.add(null);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;    
            boolean y_found = false;
            TreeNode x_parent = null;
            TreeNode y_parent = null;
            for(int i = 0;i<size; i++){
                TreeNode node = q.poll();
                TreeNode parent = qp.poll();
                if(x==node.val){
                    x_found = true;
                    x_parent = parent;
                }
                if(y==node.val){
                    y_found = true;
                    y_parent = parent;
                }
                if(node.left!=null){
                    q.add(node.left);
                    qp.add(node);
                }
                if(node.right!=null){
                    q.add(node.right);
                    qp.add(node);
                }
            }
            if(x_found && y_found && (x_parent != y_parent)) {
                return true;
            }
        }
        return false;
    }
}