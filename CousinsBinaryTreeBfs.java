// Time Complexity : O(n)
// Space Complexity : O(n)

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
    
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_flag = false;
            boolean y_flag = false;
            for(int i = 0;i < size;i++){
                TreeNode node = q.poll();
                if(node.left != null && node.right != null){
                    if((node.left.val == x && node.right.val == y) || 
                      (node.left.val == y && node.right.val == x))
                        return false;
                }
                if(node.val == y)
                    y_flag = true;
                else if(node.val == x)
                    x_flag = true;
                if(node.left != null)   q.add(node.left);
                if(node.right != null)  q.add(node.right);
            }
            if(x_flag && y_flag)    return true;
            if(x_flag || y_flag)    return false;
        }
        return false;
    }
}