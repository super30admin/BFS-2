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
        
        //Create a list for storing output.
        
        LinkedList result = new LinkedList();
        
        //check if the tree is null
        
        if(root == null){
            return result;
        }
        
        //Create a queue for BFS traversal.
        
        LinkedList<TreeNode> queue = new LinkedList();
        
        //Add the first node of the tree to the queue.
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            //record the number of elements previously stored in queue before you start adding more elements.
            
            int length = queue.size();
            
            //Go through each element of the queue.
            
            for(int i = 0; i < length; i++){
                
                //remove the element from queue front.
                
                TreeNode current = queue.remove();
                
                //Condition to check if the node is last node from a level.
                
                if(i == length - 1){
                    result.add(current.val);
                }
                
                //check if any neighbors are there and add them to the queue.
                
                if(current.left != null){
                    queue.add(current.left);
                }
                
                if(current.right != null){
                    queue.add(current.right);
                }
            }
        }
        
        return result;
    }
}