// Problem1 (https://leetcode.com/problems/cousins-in-binary-tree/)
// using DFS
// T - O(n) and S - O(n)
class Solution {
    int y_depth;
    int x_depth;
    int x_parent;
    int y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        isCousins(root, x, y, null, 0);
        return y_depth == x_depth && y_parent != x_parent;
    }
    
    private void isCousins(TreeNode root, int x, int y, TreeNode parent, int depth)     {
        if(root == null){
            return ;
        }
        
        if(parent != null){
             if(root.val == x){
                x_depth = depth;
                x_parent = parent.val;
            }else if(root.val == y){
                y_depth = depth;
                y_parent = parent.val;
            }
        } 
        
       
        
        isCousins(root.left, x, y, root, depth + 1);
        isCousins(root.right, x, y, root, depth + 1);
    }
}

// using BFS
// T - O(n) and S - O(n)
class Solution {
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            boolean x_found = false, y_found = false;
            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x) x_found = true;
                else if(curr.val == y) y_found = true;
            
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y){
                        return false;
                    }
                    if(curr.left.val == y && curr.right.val == x){
                       return false;
                    }
                }

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
         
            }
            
            if(x_found && y_found)
                return true;
            
            if(x_found || y_found){
                return false;
            }
                
               
        }
        
        
        
        return false;
    }
    

}