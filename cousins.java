//time O(N) N is the no of nodes in tree
//space O(N/2) => O(N) width of the tree OR size of the queue
//approach BFS

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
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || (root.left == null && root.right == null)) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int count = 0;
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null && curr.right != null) {
                    if(
                        (curr.left.val == x || curr.left.val == y) &&
                        (curr.right.val == x || curr.right.val == y)
                    ) return false;
                }
                if(curr.left != null) {
                    if(curr.left.val == x || curr.left.val == y) count++;
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    if(curr.right.val == x || curr.right.val == y) count++;
                    q.add(curr.right);
                }
            }
            if(count == 2) return true; 
        }
        return false;
    }
} 
