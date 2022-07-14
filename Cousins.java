// Time Complexity : O(n)
// Space Complexity : O(n)
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
class Cousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root.val==x || root.val==y)
            return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;
            for(int i=0;i<size;i++) {
                root = queue.poll();
                if(root.val==x)
                {
                    if(foundY)
                        return true;
                    
                    foundX = true;
                }
                
                if(root.val==y)
                {
                    if(foundX)
                        return true;
                    
                    foundY = true;
                }
                
                if((root.left!=null && root.right!=null) && ((root.left.val==x && root.right.val==y) || (root.left.val==y && root.right.val==x)))
                    return false;
                
                if(root.left!=null) queue.add(root.left);
                if(root.right!=null) queue.add(root.right);
            }
        }
        
        return false;
    }
}
