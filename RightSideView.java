/*TC - O(N) SC O(N)*/


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // level order traversal  , and the last elemnt of every array list at that level
       
        List<Integer> levels= new ArrayList<>();
        if (root == null){
            return new ArrayList<>();
        }
        
        Queue<TreeNode> queue  = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
       
            int size = queue.size();
            for (int i = 0 ; i < size; i++){
                TreeNode elem = queue.poll();
                if ( i == size-1){
                    // if its the last element in the level order 
                    levels.add(elem.val);
                }
              
                 
                if (elem.left != null){
                    queue.add(elem.left);
                }
                if (elem.right !=  null){
                    queue.add(elem.right);
                }
            }
        
        }
      
      
        return levels;
        
        
    }
}
