// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * BFS solution.
 * Process the tree level by level and always update the element in the result at that level
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if (root == null) {
            return result;
        }
        
        q.add(root);
        int level = 0;
        
        while (!q.isEmpty()) {
            int levelSize = q.size();
            
            for (int i=0;i<levelSize;i++) {
                TreeNode curr = q.poll();
            
                if (result.size() == level) {
                    result.add(curr.val);
                } else {
                    result.set(level, curr.val);
                }
            
                if (curr.left != null){
                    q.add(curr.left);
                }
                
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            
            level++;
        }
        
        
        return result;
    }
}