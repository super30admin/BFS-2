// Time Complexity : O(n) where n is the no of nodes in tree
// Space Complexity : O(D), size of queue (diameter of the tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use a queue and size variable. We add the root initially to the queue. Then we process root and push its children
   to the queue and get size of 2nd level. Then whenever i == size - 1, that means we are at the rightmost child. So we add to 
   result queue. In this way we go level by level and add rightmost child to result and return it.
*/

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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        q.add(root);
        int size;

        while(!q.isEmpty()) {
            size = q.size();
            for(int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                if(i == size - 1)
                    result.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
        }
        return result;
    }
}