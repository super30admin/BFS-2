# BFS-2

## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

# Solution 1 DFS
# Time Complexity : O(n)
# Space Complexity : O(h)
class Solution {
    List<Integer> result; 
    public List<Integer> rightSideView(TreeNode root) {
        
        result = new ArrayList<>(); 
        
        if(root == null) return result; 
        
        dfs(root,0); 
        
        return result; 
    }
    
    private void dfs(TreeNode root, int level){
    
        //do left traversal first and add the replace the elements later
        if(root == null) return;
        
        if(result.size() == level){
            result.add(root.val); 
        }else{
            result.set(level,root.val);
        }
        
        dfs(root.left,level+1); 
        dfs(root.right,level+1);
        
        
    }
}

# Solution 2 DFS
# Time Complexity : O(n)
# Space Complexity : O(h)
class Solution {
    List<Integer> result; 
    public List<Integer> rightSideView(TreeNode root) {
        
        result = new ArrayList<>(); 
        
        if(root == null) return result; 
        
        dfs(root,0); 
        
        return result; 
    }
    
    private void dfs(TreeNode root, int level){
    
        //do right traversal first and add the right element first into the result
        if(root == null) return;
        
        if(result.size() == level){
            result.add(root.val); 
        }
        
        dfs(root.right,level+1);
        dfs(root.left,level+1); 
        
    }
}

# Solution 3 BFS
# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
      
        List<Integer> result = new ArrayList<>(); 
        
        if(root == null) return result; 
        
        Queue<TreeNode> q = new LinkedList<>(); 
        
        q.add(root); 
        
        while(!q.isEmpty()){
            int size = q.size(); 
            
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll(); 
                if(i == size-1){
                    result.add(node.val);
                }
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return result; 
    }
}
## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

## Solution 1 BFS

# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution {
    
    //comparing if they are from the same parent 
    //if yes return false
    //else add them to the queue
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null) return false;
        
        Queue<TreeNode> q = new LinkedList<>(); 
        
        q.add(root); 
        
        while(!q.isEmpty()){
            int size = q.size(); 
            boolean x_flag = false;
            boolean y_flag = false; 
            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll(); 
                
                if(curr.val == x) x_flag = true; 
                if(curr.val == y) y_flag = true; 
                
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false; 
                }
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right); 
            }
            
            if(x_flag && y_flag) return true;
            if(x_flag || y_flag) return false;
        }
        
        return false;
    }
}

## Solution 2 : DFS

# Time Complexity : O(n)
# Space Complexity : O(h)

class Solution {
    
    //keep updating the parents if we find the values
    //compare at the end if x's parent is not equal to y
    //compare if depths are same
    int x_depth;
    int y_depth; 
    TreeNode x_parent; 
    TreeNode y_parent; 
    public boolean isCousins(TreeNode root, int x, int y) {
       
        if(root == null) return false; 
        
        dfs(root, null, 0, x, y); 
        
        if(x_parent != y_parent && x_depth == y_depth) return true;
        
        return false;
    }
    
    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y){
        if(root == null) return; 
        
        if(root.val == x){
            x_parent = parent;
            x_depth = depth;
        }
        
         if(root.val == y){
            y_parent = parent;
            y_depth = depth;
        }
        
        dfs(root.left, root, depth + 1, x, y);
        dfs(root.right, root, depth + 1, x, y); 
    }
}





