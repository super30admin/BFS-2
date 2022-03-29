import java.util.LinkedList;
import java.util.Queue;

/**
 * Implemented using BFS
 * 
 * Time complexity is O(n)
 * space complexity is O(n)
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean foundx = false;
            boolean foundy = false;
            for(int i = 0; i < size; i++) {
                boolean fx = false;
                boolean fy = false;
                TreeNode node = queue.remove();
                if(node.left != null) {
                    queue.add(node.left);
                    if(node.left.val == x) {
                        foundx = true;
                        fx = true;
                    }
                    else if(node.left.val == y) {
                        foundy = true;
                        fy = true;
                    }
                }
                if(node.right != null) {
                    queue.add(node.right);
                    if(node.right.val == x) {
                        foundx = true;
                        fx = true;
                    }
                    else if(node.right.val == y) {
                        foundy = true;
                        fy = true;
                    }
                }
                // sibling check
                if(fx && fy) {
                    return false;
                }
            }
            // cousin check
            if(foundx && foundy) {
                return true;
            }
            if(foundx && !foundy || !foundx && foundy) {
                return false;
            }
        }
        
        return false;
    }
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
}