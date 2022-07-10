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
    
    /*
     * Do a level order traversal, and pick up last element from every level
     *
     * We need a size variable, because every level need to be distinguished. 
     *
     * BFS solution.
     *
     *
     * Timecomplexity: O(no.of nodes in tree) -> because we visit every node.
     * Space complexity: O(no.of leaf nodes) -> Beacuse on the last level queue holds that many elements.
     *
     */
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            
            
            int size = q.size();
            
            for(int i= 0; i< size; i++) {
                TreeNode curr = q.poll();
                
                // We are on last element of that level so add to result
                if( i == size - 1) {
                    result.add(curr.val);
                }
            
                // Add the left & right to queue for further processing.
                if(curr.left != null) 
                    q.add(curr.left);
                if(curr.right != null) 
                    q.add(curr.right);
                
            }
        }
        
        return result;
        
    }
}
