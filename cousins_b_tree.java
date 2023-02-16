//Time Complexity O(N)
//Space Complexity O(H)

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>() ; 
        // ArrayList<Integer> left = new ArrayList<>() ; 
        // ArrayList<Integer> right = new ArrayList<>() ;

        if(root == null) return false ; 
        
        q.add(root) ; 

        while(!q.isEmpty()){
            int size = q.size() ; 
            boolean x_found  = false ; 
            boolean y_found = false ; 

            for(int i = 0 ; i < size ; i ++){
                TreeNode curr = q.poll() ; 
                if(curr.val == x){
                    x_found = true ; 
                }
                if(curr.val == y){
                    y_found = true ; 
                }
                if(curr.left!= null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y){
                        return false ; 
                    }
                    if(curr.left.val == y && curr.right.val == x){
                        return false ; 
                    }
                }
                if(curr.left!= null){
                    q.add(curr.left) ; 
                }

                if(curr.right!= null){
                    q.add(curr.right) ; 
                }

            }
            
            if(x_found == true && y_found == true){
                return true ; 
            }

            else if(x_found == true || y_found == true){
                return false ; 
            }
        }

        return true ; 
        
    }
}
