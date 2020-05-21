
//Time complexity: O(N) N is number of nodes
//Space complexity: O(N)

/**
 * DFS
 * 1. Maintain the depth from root and parent for every node in the recusrive stack
 * 2. When reached to nodes x and y, record its depth and parent.
 * 3. At the end check if depths are equal for x and y, and parents are not equal.
 */

 /**
 * BFS
 * 1. Traverse the tree levelwise, so it is not required to keep track of depth.
 * 2. at each level check if x and y are found.
 * 3. Don't add those node in bfs queue, who has its children as x and y.
 */

public class CousinNodes {
    
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

 
    
    int x_depth, y_depth;
    TreeNode x_parent, y_parent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null)
            return false;
        
        x_depth = 0;
        y_depth = 0;
        x_parent = root;
        y_parent = root;
        
//         /** BFS */
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
       
//         while(!q.isEmpty()){
            
//             int size = q.size();
//             boolean xFound = false, yFound = false;
//             for(int i=0; i<size; i++) {
                
//                 TreeNode node = q.poll();
//                 if(node.val == x)
//                     xFound = true;
//                 if(node.val == y)
//                     yFound = true;
                
//                 if(node.left != null && node.right != null){
//                     if((node.left.val == x && node.right.val == y) ||
//                       node.left.val == y && node.right.val == x)
//                         return false;
//                 }
                
//                 if(node.left != null)
//                     q.add(node.left);
//                 if(node.right != null)
//                     q.add(node.right);
                
//             }
            
//             if(xFound && yFound)
//                 return true;
//         }
        
        dfs(root, x, y, 0, root);
        
        return x_depth == y_depth && (x_parent != y_parent);
        
    }
    
    private void dfs(TreeNode node, int x, int y, int depth, TreeNode parent) {
        
        //Base
        if(node == null)
            return;
        
        //Logic
        
        if(node.val == x){
            x_depth = depth;
            x_parent = parent;
            
        }
        if(node.val == y) {
            y_depth = depth;
            y_parent = parent;
        }
        
        dfs(node.left, x, y, depth+1, node);
        dfs(node.right, x, y, depth+1, node);
        
        
    }

}