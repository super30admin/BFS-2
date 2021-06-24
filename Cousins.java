// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

/**
 * In this approach, I have implemented BFS approach and try to find both x and Y on th same level
 * If one element is found but not the other, we return false
 * We return true only when we find x and y on same level and with different parents
 */

class Solution {
    
    // BFS approach
    // we can check if both x and y are present on the same level
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) return false;
        
        boolean x_found = false;
        boolean y_found = false;
        
        TreeNode x_parent = null;
        TreeNode y_parent = null;
        
        Queue<TreeNode[]> q = new LinkedList<>();
        
        // (root, parent)
        q.add(new TreeNode[]{root, null});
        
        while(!q.isEmpty()) {
            int sze = q.size();
            
            for(int i=0;i<sze;i++) {
                TreeNode[] current = q.poll();
                
                if(current[0].val == x) {
                    x_found = true;
                    x_parent = current[1];
                }
                if(current[0].val == y) {
                    y_found = true;
                    y_parent = current[1];
                }
                
                if(current[0].left != null){
                    q.add(new TreeNode[]{current[0].left, current[0]});
                }
                if(current[0].right != null){
                    q.add(new TreeNode[]{current[0].right, current[0]});
                }
            }
            
            if((x_found && !y_found) || (!x_found && y_found)) {
                return false;
            }
            
            if((x_found && y_found) && x_parent != y_parent) {
                return true;
            }
        }
        return false;
    }
}
