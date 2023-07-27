// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(n), where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Use BFS to traverse the tree level by level
 * 2. Keep track of the parent node of x and y
 * 3. If x and y are found at the same level, check if they have different parents
 * 4. If x and y are found at different levels, return false
 * 5. If x and y are found at the same level, and parent are different, return true
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> parent = new LinkedList<>();
        queue.offer(root);
        parent.offer(null);
        boolean xfound = false, yfound = false;;
        TreeNode xParent = null, yParent = null;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode currNode = queue.poll();
                TreeNode parentNode = parent.poll();

                if(currNode.val == x){
                    xfound = true;
                    xParent = parentNode;
                }

                if(currNode.val == y){
                    yfound = true;
                    yParent = parentNode;
                }

                if(currNode.left != null){
                    queue.offer(currNode.left);
                    parent.offer(currNode);
                }

                if(currNode.right != null){
                    queue.offer(currNode.right);
                    parent.offer(currNode);
                }
            }

            if(xfound && yfound)
                return xParent != yParent;
            
            if(xfound || yfound)
                return false;
        }

        return false;
    }
}