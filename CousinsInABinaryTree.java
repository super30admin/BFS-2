/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            boolean xExists= false, yExists = false;
            for(int i = 0;i <size; i++) {
                TreeNode node = q.poll();
                if(!xExists && node.val == x) {
                    xExists = true;
                }

                if(!yExists && node.val == y) {
                    yExists = true;
                }


                if(node.left!= null && node.right!= null && ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x))) {
                    return false;
                }

                if(node.left!=null) {
                    q.offer(node.left);
                }

                if(node.right!=null) {
                    q.offer(node.right);
                }
            }
            if(xExists && yExists) {
                return true;
            }
        }

        return false;
    }
}