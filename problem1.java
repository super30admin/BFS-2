/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//time- O(N) - #nodes
//space- O(N)- worst case
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> aList= new ArrayList<>();
        
        if(root== null) return aList;
        
        Queue<TreeNode> q= new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int n= q.size();
            
            for(int i=0; i<n; i++){
                
                 TreeNode current= q.remove();
                
                if(i== n-1){
                    
                    aList.add(current.val);
                }
                
                
                if(current.left!=null){
                    
                    q.add(current.left);
                }
                
                if(current.right!=null){
                    q.add(current.right);
                }
                
            }
            
        }
        
        return aList;
        
        
        
    }
}