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
 
 TC = O(N) where N is the number of nodes in the binary tree
 SC = O(H) where H is the height of the binary tree.

 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        if (root == null)
        {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int qSize = queue.size();
            
            for (int i=0; i<qSize; i++)
            {
                TreeNode remove = queue.remove();
                
                if (remove.left != null)
                {
                    queue.add(remove.left);
                }
                
                if (remove.right != null)
                {
                    queue.add(remove.right);
                }
                
                if (i == qSize - 1)
                {
                    result.add(remove.val);
                }
            }
        }
        
        return result;
    }
}
