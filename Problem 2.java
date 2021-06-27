// Time Complexity : O(N) 
// Space Complexity : O(N) if the cousins are on the last level (last level has max (N/2+1) nodes which is N)
// Did this code successfully run on Leetcode : yes, still need to fully learn this better

// Three line explanation of solution in plain english
// Add root node to queue then going down the tree until we find the level of the first x or y
// If they are both not in that level, or if the two values stem from same parent then they are not cousins
 
//
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x) x_found = true;
                if(curr.val == y) y_found = true;
                //check if x and y are siblings
                if(curr.left != null && curr.right != null){ 
                    if(curr.left.val == x  && curr.right.val == y) return false;
                    if(curr.left.val == y  && curr.right.val == x) return false;
                }
                //add child nodes to queue
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(x_found && y_found) return true; // if we found both then they must be at the same level and not siblings
            if(x_found || y_found) return false; // if we found one then they cannot be cousins
        }
        return true;
    }
}