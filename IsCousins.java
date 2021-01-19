// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : The space complexity if O(l) where l is the maximum number of nodes in a level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(new TreeNode(-1));
        int size = q.size();
        int depth = 0;

        // Maintain parent and depth data for x and y
        int xParent = 0;
        int yParent = 0;
        int xDepth = 0;
        int yDepth = 0;

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            TreeNode parent = q.poll();
            size -= 2;

            // If x is found, store its depth and parent
            if(node.val == x){
                xDepth = depth;
                xParent = parent.val;
            }

            // If y is found, store its depth and parent
            if(node.val == y){
                yDepth = depth;
                yParent = parent.val;
            }

            if(node.left!=null){
                q.offer(node.left);
                q.offer(node);
            }

            if(node.right!=null){
                q.offer(node.right);
                q.offer(node);
            }

            if(size==0){
                depth++;
                size=q.size();
            }
        }

        return (xDepth == yDepth) && (xParent != yParent);

    }
}