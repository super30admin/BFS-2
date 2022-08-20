//TC = O(n)
//SC = O(h)

class Solution {
      TreeNode x_parent;
      TreeNode y_parent;
      int x_depth;
      int y_depth;
        
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, x, y, 0, root);
        return x_depth == y_depth && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        //base
        if(root == null) return;
        
        //logic
        if(root.val == x){
            x_parent = parent;
            x_depth = depth;
        }
        
        if(root.val == y){
            y_parent = parent;
            y_depth = depth;
        }
        
        dfs(root.left, x,y, depth+1, root);
        dfs(root.right, x,y, depth+1, root);
    }
}




//TC = O(n)
//SC = O(h)
//Please explain if(x_parent == null || y_parent == null) , why we are checking this condition
class Solution {
      TreeNode x_parent;
      TreeNode y_parent;
      int x_depth;
      int y_depth;
        
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, x, y, 0, root);
        return x_depth == y_depth && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        //base
        if(root == null) return;
        
        //logic
        if(root.val == x){
            x_parent = parent;
            x_depth = depth;
        }
        
        if(root.val == y){
            y_parent = parent;
            y_depth = depth;
        }
        
        if(x_parent == null || y_parent == null)
           dfs(root.left, x,y, depth+1, root);
        if(x_parent == null || y_parent == null)
           dfs(root.right, x,y, depth+1, root);
    }
}




//TC = O(n)  No of nodes
//SC = O(n)  width/ Breadth / max width = n/2=>n


//BFS
class Solution {

        
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            
            boolean x_found = false; 
            boolean y_found = false;

            for(int i=0; i<size; i++){
                TreeNode curr = q.poll(); 
                
                if(curr.val == x) x_found = true; //found an value
                if(curr.val == y) y_found = true;
                
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false; // same parent
                    if(curr.right.val == x && curr.left.val == y) return false; // same parent             
                 }
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(x_found && y_found) return true;
            if(y_found || y_found) return false;
        }
        return false;
    }
}
