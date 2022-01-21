# BFS-2

## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

// Solution 
//Runs successfully on leetcode
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
class Solution {
    //Space Complexity:O(H) - height of the tree, worst case: O(N)
    //Time Complexity: O(N)
    //Breadth First Search using queue
    /*
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList <TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<Integer>();
        if (root== null) return result;
        queue.add(root);
        while(! queue.isEmpty())
        {
            int size = queue.size();
            result.add(queue.get(size-1).val);
            for(int i=0; i< size; i++)
            {
                TreeNode curr = queue.poll();
                if(curr.left!= null) queue.add(curr.left);
                if(curr.right!= null) queue.add(curr.right);
            }
            
        }
        return result;
    }*/
    
    //Space Complexity:O(H) - height of the tree, worst case: O(N)
    //Time Complexity: O(N)
    //Depth First Search using recusive stack - 1) recurse on right subtree first 2) normal DFS
    List<Integer> result;
    
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<Integer>();
        dfsTraversal(root, 0);
        return result;
    }
    
    private void dfsTraversal(TreeNode root, int level)
    {
        //base
        if(root == null) return;
        //logic 
        if(level == result.size())
        {
            result.add(root.val);
        }
        /*else
        {
            result.set(level, root.val);
        }*/
        //recursion
        //dfsTraversal(root.left, level+1);
        dfsTraversal(root.right, level +1);
        dfsTraversal(root.left, level+1);
    }
    
    
}


## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

//Runs successfully on leetcode 
//Solution 
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
class Solution{
    
    //Time Complexity: O(N) - N = Number of nodes
    //Space Complexity: O(H) - H = height of the tree
    private boolean bfsTraversal(TreeNode root, int x, int y)
    {
        boolean x_found = false;
        boolean y_found = false;
        LinkedList <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0; i< size; i++)
            {
                TreeNode curr = queue.poll();
                if(curr.val == x)
                    x_found = true;
                if(curr.val == y)
                    y_found = true;
                
                if(curr.left!= null) queue.add(curr.left);
                if(curr.right!= null) queue.add(curr.right);
                
                if(curr.left != null && curr.right != null)
                {
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                
            }
            if(x_found == true && y_found == false) return false;
            if(y_found == true && x_found == false) return false;
            
            
        }
        return true;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root== null) return false;
        return bfsTraversal(root, x, y);
        
        
        
        
    }
}
/*class Solution {
    TreeNode x_parent; 
    TreeNode y_parent;
    int x_height;
    int y_height;
    
    private void dfsTraversal(TreeNode root, TreeNode parent, int height, int x, int y)
    {
        //base 
        if(root == null) return;
        //logic 
        if(x == root.val)
        {
            x_parent = parent;
            x_height = height;
           
        }
        if(y == root.val)
        {
            y_parent = parent;
            y_height = height;
           
        }
        //recursion
        //if(x_parent != null && y_parent != null) return;
        if(x_parent == null || y_parent == null) 
        dfsTraversal(root.left, root, height+1, x, y);
        //if(x_parent != null && y_parent != null) return;
        if(x_parent == null || y_parent == null) 
        dfsTraversal(root.right, root, height+1, x, y);
        
    }
   
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root== null) return false;
        dfsTraversal(root, null, 0, x, y);
        if(x_parent == y_parent ) return false;
        if(x_height != y_height) return false;
        return true;
        
        
        
    }
}
*/

