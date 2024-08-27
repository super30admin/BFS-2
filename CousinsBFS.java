import java.util.LinkedList;
import java.util.Queue;

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
class CousinsBFS {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            // The reason we write it here
            // is because if it is kept outside- if the grandfather is true and the father is true, still we will get it as true, which defets the purpose
            // both parents need to be true.
            int size = queue.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i=0;i< size;i++) {
                TreeNode curr = queue.poll();
                // check for the value.
                if(curr.val ==  x) {
                    x_found = true;
                }
                if(curr.val ==  y) {
                    y_found = true;
                }
                if(curr.left!=null && curr.right!=null) {
                    // same parent. if both values found, return false.        
                    if(curr.left.val == x && curr.right.val ==y) {
                        return false;    
                    }
                    if(curr.left.val == y && curr.right.val==x) {
                        return false;
                    }
                }
                // push stuff into the queue.
                if(curr.left!=null) {
                    queue.add(curr.left);
                }
                // push stuff into the queue.
                if(curr.right!=null) {
                    queue.add(curr.right);
                }
            }
            // check whether the values are found.
            if(x_found && y_found) {
                return true;
            }
        }
        return false;
    }
}