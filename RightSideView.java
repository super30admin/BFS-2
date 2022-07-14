// Time Complexity : O(N)
// Space Complexity : O(N)
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
class RightSideView {
    List<Integer> results;
    public List<Integer> rightSideView(TreeNode root) {
        results = new ArrayList<>();
        
        if(root==null)
            return results;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++) {
                root = queue.poll();
                if(i==0)
                    results.add(root.val);
                if(root.right!=null) queue.offer(root.right);
                if(root.left!=null) queue.offer(root.left);
            }
        }
        
        return results;
    }
}
