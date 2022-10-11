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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        
        result = new ArrayList<>();
        
        if(root == null) return result;
        
        // Method - 1 BFS
        // TC : O(n)
        // SC : O(n)
        
        /*Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i< size; i++) {
                TreeNode cur = q.poll();
                if(i == size -1)
                    result.add(cur.val);
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
        }*/
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int lvl) {
        
        // Method - 1 DFS
        // TC : O(n)
        // SC : O(h)
        if(root == null) return;
        
        if(lvl == result.size())
            result.add(root.val);
        
        helper(root.right, lvl+1);
        helper(root.left, lvl+1);
    }
}
