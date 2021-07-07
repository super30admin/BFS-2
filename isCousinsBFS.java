// Time Complexity :O(n) n is the nodes of the tree;
// Space Complexity :O(n/2) n is the nodes of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean isX = false;
            boolean isY = false;
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val == x) isX = true;
                if(curr.val == y) isY = true;
                if(curr.left!=null && curr.right!=null){
                    if((curr.left.val == x || curr.right.val == x) && (curr.left.val == y || curr.right.val == y)) return false;
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(isX && isY) return true;
            if(isX || isY) return false;
        }
        
        return false;
    }
}