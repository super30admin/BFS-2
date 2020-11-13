// Time Complexity :  O(N) no of nodes
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


public class Solution {
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            boolean x_found = false;
            boolean y_found = false;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.val == x) x_found = true;
                if(node.val == y) y_found = true;
                if(node.left!= null && node.right!=null){
                    if((node.left.val == x && node.right.val == y ) || (node.left.val == y && node.right.val == x)){
                        return false;
                    }
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            if(x_found && y_found){
                return true;
            }
            
        }
        return false;
    }
}