// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach in three sentences only:BFS approach just following the four variable x_found,y_found,x_parent and y_parent if x_found and y_fount became true then i am checking wheather those parents are equal or not in same level ,if not just returning true.
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        boolean x_found = false;
        boolean y_found = false;
        TreeNode x_parent = null;
        TreeNode y_parent = null;
        
        q.add(root);
        pq.add(null);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                TreeNode parent = pq.poll();
                 if (current.val == x) {
                        x_found = true;
                        x_parent = parent;
                    }
                    if (current.val == y) {
                        y_found = true;
                        y_parent = parent;
                    }
                if (current.left != null) {
                    q.add(current.left);
                    pq.add(current);
                }
                
                if (current.right != null) {
                    q.add(current.right);
                    pq.add(current);
                }
            }
        
      if (x_found && y_found) {
              return x_parent != y_parent;
        }
         if (x_found || y_found) {
             return false;
        }
        }
        
        
        return false;
    }
}
