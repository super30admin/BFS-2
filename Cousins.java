// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since in worst case scenario we might have to reach all levels 
//Space Complexity: O(n) or O(L) where L is number of levels since we are using additional queue
 public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
         var xfound = false;
         var yfound = false;
        while(!queue.isEmpty()){          
            
        int size = queue.size();
            
            for(int i = 0; i<size; i++){
                TreeNode curr = queue.poll();
                
                if(curr.left != null){
                    queue.add(curr.left);                                    
                    
                }
                
                if(curr.right != null){
                    queue.add(curr.right);        
                }
               
                if(curr.left!= null && curr.right!=null){
                    if((curr.left.val == x && curr.right.val == y) || (curr.right.val==x && curr.left.val==y)){
                        return false;
                    }
                }
                
                if(curr.val == x){
                    xfound = true;
                }
                if(curr.val == y){
                    yfound = true;
                }
                if(xfound && yfound){
                    return true;
                }
            }
            
            xfound = false;
            yfound = false;

            }
            return false;
    }
