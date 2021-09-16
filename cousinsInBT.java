// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 0;
        boolean x_found; boolean y_found;
        while(!q.isEmpty()){
            size = q.size();
            x_found = false;
            y_found = false;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x) x_found = true;
                if(curr.val == y) y_found = true;
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.right.val == x && curr.left.val == y) return false;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            // check if x & y in same level
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
        return false;
    }
}