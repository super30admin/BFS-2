//time and space = O(n)
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
   // right side view
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return result;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode current=queue.remove();
                
                
                if(0==i)
                    result.add(current.val);
                
                
                
                if(current.left!=null)
                    queue.add(current.left);
       
            }
        }
        
        return result;
    }
}
