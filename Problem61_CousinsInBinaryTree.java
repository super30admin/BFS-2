// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean isAExist = false;
            boolean isBExist = false;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.val == x)
                    isAExist = true;
                if(node.val == y)
                    isBExist = true;
                if(node.left != null && node.right != null) {
                    if(node.left.val == x && node.right.val == y)
                        return false;
                    if(node.right.val == x && node.left.val == y)
                        return false;
                }
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            if(isAExist == true && isBExist == true)
                return true;
        }
        return false;
    }
}