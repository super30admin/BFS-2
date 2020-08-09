// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.LinkedList;
import java.util.Queue;

// Your code here along with comments explaining your approach
// Approach 1: Using BFS
// 1. Do level order traversing
// 2. Check if the nodes are present in same level
// 3. PreCheck -> While processing any node check if both of its children are targets
// 4. If not add to queue
// Time Complexity : O(n)
//      n: number of nodes
// Space Complexity : O(n/2) = O(n)
//      n: number of nodes
class Problem1S1 {
    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /** find two nodes are cousins */
    public boolean isCousins(TreeNode root, int x, int y) {

        // edge cases
        if(root != null && root.val != x && root.val != y){

            // qeue for FIFO
            Queue<TreeNode> myQueue = new LinkedList<>();
            myQueue.add(root);
            
            // process level by level
            while(!myQueue.isEmpty()){

                // level (height) of the tree
                int size = myQueue.size();
                boolean xFound = false; 
                boolean yFound = false;

                while(size != 0){
                    
                    TreeNode current = myQueue.poll();
                    // check node is target
                    if(current.val == x)
                            xFound = true;
                    if(current.val == y)
                            yFound = true;

                    // target not found
                    if (!(xFound || yFound)){
                        // check children are target
                        if(current.left != null && current.right != null){
                            if(current.left.val == x && current.right.val == y)
                                return false;
                    
                            if(current.left.val == y && current.right.val == x)
                                return false;    
                        }
                    }
                    
                    // add next level nodes
                    if(current.left != null)
                        myQueue.add(current.left);
                    if(current.right != null)
                        myQueue.add(current.right);
                    
                    size--;   
                }

                // both found on same level
                if(xFound && yFound)
                    return true;
                // either of them is found on same level
                else if(xFound || yFound)
                    return false;
                
            }
            
        }
        
        // default
        return false;
        
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Using DFS
// 1. Find the target nodes using DFS
// 2. Save depth and parent of the targets
// 3. Check if the nodes are present in same level
// 4. Also check that both have different parent
// Time Complexity : O(n)
//      n: number of nodes
// Space Complexity : O(h)
//      h: height of the tree
class Problem1S2 {
    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }    

    // global parent and depth
    TreeNode xParent, yParent;
    int xDepth, yDepth, x, y;
    
    /** find if both are cousins */
    public boolean isCousins(TreeNode root, int x, int y) {
        
        // base case
        if(root != null && root.val != x && root.val != y){
            // for having global value
            this.x = x;
            this.y = y;
            depthFirst(root, 0, null);
            // if depth is equal and different parent
            if(xDepth == yDepth && xParent != yParent)
                return true;
        }

        // default
        return false;
    
    }
    
    /** DFS traversal  */ 
    private void depthFirst(TreeNode root, int level, TreeNode parent){

        // base case
        if(root!= null){

            // check if node is eithe of the targets
            if(root.val == x){
                // save info
                xDepth = level;
                xParent = parent;
                return;
            }
            if(root.val == y){
                // save info
                yDepth = level;
                yParent = parent;
                return;
            }

            // increase level
            level++;

            // go left and right
            depthFirst(root.left,level, root);
            depthFirst(root.right,level, root);
            
        }
    }
}