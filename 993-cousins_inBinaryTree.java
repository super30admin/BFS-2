//Approach-1: Using the BFS
//Overall Time Complexity: O(N)
//Overall Space Complexity: O(N) -> Leaf nodes in the queue 
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        boolean x_cousin = false;
        boolean y_cousin = false;
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
               TreeNode node = q.poll();
                
                //Check for the siblings here
                if(node.left != null && node.right != null){
                    if(node.left.val == x && node.right.val == y) return false;
                    if(node.left.val == y && node.right.val == x) return false;
                }
                
                if(node.val == x) x_cousin = true;
                if(node.val == y) y_cousin = true;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(x_cousin && y_cousin) return true;
            if(x_cousin || y_cousin) return false;
        }
        
        return false;
    }
}


//Approach-2: Using the DFS
//Overall Time Complexity: O(N)
//Overall Space Complexity: O(H) - Height of the recursion stack
class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_h;
    int y_h;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return x_parent != y_parent && x_h == y_h;
    }
    
    public void dfs(TreeNode node, int x, int y, int level, TreeNode parent){
        if(node == null) return;
        
        
        if(node.val == x){
            x_parent = parent;
            x_h = level;
        }else if(node.val == y){
            y_parent = parent;
            y_h = level;
        }
        
        dfs(node.left, x, y, level+1, node);
        dfs(node.right, x, y, level+1, node);
        return;
    }
}