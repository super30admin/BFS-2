// Time Complexity : O(N)
// Space Complexity : BFS-> O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            boolean xFound = false;
            boolean yFound = false;
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;
                if(curr.left != null && curr.right != null)
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x))
                        return false;
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(xFound && yFound) return true;
            if(xFound || yFound) return false;
        
        }
        return false;
    }
}
