// BFS solution

// Time complexity: O(N)
// Space complexity: O(W)
// Run on leetcode: Yes
// Issues faced: None

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || x == y)
            return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean x_flag = false;
            boolean y_flag = false;
            boolean level = false;
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                
                if(node.left != null && node.right != null){
                  //On the same level; have same parent
                    if((node.left.val == x || node.left.val == y) && (node.right.val == x || node.right.val == y))
                        return false;
                }
              // On the same level; have different parents 
                if(x_flag || y_flag && level){
                    if(node.val == x || node.val == y)
                        return true;
                }
              // not on same level; have different parents
                if(x_flag || y_flag && !level){
                    if(node.val == x || node.val == y)
                        return false;
                }
              // if found x or y
                if(node.val == x || node.val == y){
                    if(node.val == x)
                        x_flag = true;
                    else
                        y_flag = true;
                    level = true;
                }
              // add children to queue
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            
            level = false;
        }
        return false;
    }
}

// DFS solution

// Time complexity: O(N)
// Space complexity: O(H)
// Run on leetcode: Yes
// Issues faced: Was not understanding if the base case of my recursion should return true or false.

class Solution {
    int x;
    int y;
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        return dfs(root, 0, null);
    }
    
    private boolean dfs(TreeNode root, int level, TreeNode parent){
        //base
        if(root == null)
            return false;
        //logic
        if(root.val == x){
            x_depth = level;
            x_parent = parent;
        }     
        if(root.val == y){
            y_depth = level;
            y_parent = parent;
        }    
        if(x_depth != 0 && x_depth == y_depth && x_parent != y_parent)
            return true;
            
        boolean case1 = dfs(root.left, level+1, root);
        boolean case2 = dfs(root.right, level+1, root);
        return case1||case2;
    }
}
