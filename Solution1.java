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
/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        
        while(queue.size() > 0){
            int size = queue.size();
            while(size > 0){
                
                if(size==1 && queue.getFirst()!=null){
                    list.add(queue.getFirst().val);
                }
                
                TreeNode rm = queue.removeFirst(); 
                
                if(rm!=null && rm.left!=null){
                    queue.addLast(rm.left);
                }
                if(rm!=null && rm.right!=null){
                    queue.addLast(rm.right);                        
                }
                
                size = size - 1;
                
            }
            
            
        }
        
        return list;
    }
}
