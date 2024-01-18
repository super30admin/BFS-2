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

 //TC: O(n)
 //sc: O(n)
 class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        q.add(root);
        pq.add(null);
        TreeNode parent_x = null;
        TreeNode parent_y = null;
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                TreeNode CurrP = pq.poll();
                if(curr.val == x){
                    x_found = true;
                    parent_x = CurrP;
                }
                if(curr.val == y){
                    y_found = true;
                    parent_y = CurrP;
                }
                if(curr.left != null){
                    q.add(curr.left);
                    pq.add(curr);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    pq.add(curr);
                
                }
            }
            if(x_found && y_found){
                return parent_x != parent_y;
            }

            if(x_found || y_found){
                return false;
            }

           
                
         }
         return false;
    }
}