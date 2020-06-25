/*
    Using DFS

    Time complexity : O(N)
    space complexity :  recursive stack space O(H)
    is worked on leetcode : YES

*/

public class Cousins {
    


    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        dfs(root,0,null,x,y);
        
        return  (x_parent != y_parent) && (x_depth == y_depth); 
        
        
    }
    
    private void dfs( TreeNode root, int depth,TreeNode parent,int x, int y){
        // base
        if (root == null) return;
        //logic
        
        if(root.val == x ){
            x_depth =  depth;
            x_parent = parent;
        }
        
            if(root.val == y){
            y_depth =  depth;
            y_parent = parent;
        }
        
        
        dfs(root.left, depth + 1, root, x,y);
        
        dfs(root.right, depth + 1, root, x,y);
    }


    /*
        BFS approach
    */

    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        
        Queue<TreeNode> queue = new LinkedList();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            Boolean x_found = false;
            Boolean y_found = false;
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.val == x) x_found = true;
                if(node.val == y) y_found = true;     
                
                if(node.left != null && node.right!=null){
                    if(node.left.val == x && node.right.val == y) return false;
                    if(node.right.val == x && node.left.val == y) return false;
                }
                
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            
            if(x_found && y_found ) return true;
        }
        
        return false;
    }
}
