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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList();
        if(root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(! q.isEmpty()){
            int size = q.size();
            
            while(size >  0) {
                System.out.println("size * "+size);
                TreeNode _n = q.poll();
                size--;
                if(_n.left != null) {
                    q.add(_n.left);
                }
                if(_n.right != null) {
                    q.add(_n.right);
                }
                if(size == 0) {
                    res.add(_n.val);
                }
                // size--;
                
            }
            System.out.println("res"+res);
        }
        
        return res;
        
    }
}
