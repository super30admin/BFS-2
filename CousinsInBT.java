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

//Breadth First Search
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.add(new Pair<TreeNode, Integer>(root, -1));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            int pX= -1;
            int pY = -1;
            
            for(int i = 0; i < size; i++){
                Pair<TreeNode, Integer> front = queue.poll();
                
                TreeNode node = front.getKey();
                int parent = front.getValue();
                
                if(node.val == x){
                    pX = parent;
                }else if(node.val == y){
                    pY = parent;
                }
                
                if(node.left != null){
                    queue.add(new Pair<TreeNode, Integer>(node.left, node.val));
                }
                
                if(node.right != null){
                    queue.add(new Pair<TreeNode, Integer>(node.right, node.val));
                }
            }
            
            if(pX != -1 && pY!=-1 && pX != pY){
                return true;
            }
            
            if((pX != -1 && pY==-1) || (pX == -1 && pY != -1)){
                return false;
            }
        }
        
        return false;
    }
}

//TC: O(n)
//SC :  O(1)