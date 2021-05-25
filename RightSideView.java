// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through all the nodes
//Space Complexity: O(n) or O(L) where L is number of levels since we are using additional queue
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>  lst = new ArrayList<>();
        if(root == null){
            return lst;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i< size; i++){
                TreeNode curr = queue.poll();
                
                if(curr.left != null ){
                    queue.add(curr.left);
                }
                
                if(curr.right != null){
                    queue.add(curr.right);
                }
                
                if(i==size-1){
                    lst.add(curr.val);
                }
            }
            
        }
        return lst;
    }
}