// Time Complexity :
//BFS : O(n)
//DFS : O(n), n is number of nodes in tree
// Space Complexity : 
//BFS : O(n/2) / O(2^h) (number of leaf nodes)
//DFS : O(h), height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//DFS (Recursion)
class Solution {
    //set xval and yval (declare globally, set in isCousins)
    //instead of sending x and y at each recursive call
    //declare xparent, yparent, xlevel and ylevel globally
    //set parent as TreeNode (instead of int, even though vals are not repeated) 
    //as parent of root is null
    //to avoid null pointer exception
    TreeNode xparent; TreeNode yparent;
    int xlevel; int ylevel;
    int xval; int yval;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        //if tree is empty return false
        if(root == null) return false;
        //set xval and yval value
        xval = x;
        yval = y; 
        
        //root, parent, level
        //to keep track of parent and level of each node 
        //send x and y to check value of x and y at each call
        dfs(root, null, 0);
        
        //if both conditions are met return true
        return xparent != yparent && xlevel==ylevel;
               
    }
    
    private void dfs (TreeNode root, TreeNode parent, int level) {
        //base case
        if(root == null) return;
        
        //logic
        //if root.val = xval, set xparent as parent (roots parent)
        //and xlevel value as level 
        if(root.val == xval) {
            xparent = parent;
            xlevel = level;
        }
         //if root.val = yval, set yparent as parent (roots parent)
        //and ylevel value as level
        if(root.val == yval) {
            yparent = parent;
            ylevel = level;
        }
        
        //call dfs on root.left and root.right
        dfs(root.left, root, level+1);
        dfs(root.right, root, level+1);           
    }
}




///////////////////


//BFS
//add root to queue
//loop till queue empty :
  //get size of queue :
  //another loop (for) till size = 0
    //poll front (curr)
    //add currs children if present to the queue
    //check if curr both children are x and y, if yes, return false (checking for same parent condition)
    //check if curr.left/curr.right = x/y, if yes set that value true (xpresent/ypresent)
    // (we dont check if root = x/y , as for level 0, we have no other node other than root)
    //after for loop
  //check if both xpresent and ypresent are true : if yes, return true (same level and not same parent)
  //if either one is true, return false (cannot be in same level)
//return false 
  
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        //if tree empty return false
        if(root == null) return false;
        //if tree empty return false
        Queue<TreeNode> q = new LinkedList<>();
         //add root to queue
        q.add(root);
        //set xpresent and ypresent to false (set outside for loop) (if both get true in the for loop (same level))
        boolean xpresent = false;
        boolean ypresent = false;
        
        //do till queue is empty
        while(!q.isEmpty()) {
            //set size
            int size = q.size();
             //loop till size = 0 (each level)
            for(int i = 0; i < size; i++) {
                //get front of queue
                TreeNode curr = q.poll();
                //add currs children to queue
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                
                //check if currs children are both x and y
                //for not same parent condition
                //if x and y have same parent return false 
                if(curr.left != null && curr.right!= null) {
                    if((curr.left.val == x || curr.right.val == x) && (curr.left.val == y || curr.right.val == y)) 
                    return false; 
                }
                //if either x/y = curr.left, set xpresent/ypresent to true respectively
                if(curr.left != null) {
                    if (curr.left.val == x) xpresent = true;
                    if (curr.left.val == y) ypresent = true;
                }
                //if either x/y = curr.right, set xpresent/ypresent to true respectively
                if(curr.right != null) {
                    if (curr.right.val == x) xpresent = true;
                    if (curr.right.val == y) ypresent = true;
                }
            }
            //if both xpresent and ypresent are true, then both in same level (cousins) return true
            if(xpresent && ypresent) return true;
            //if either one is present and other is not, then return false as both are not in same level then
            if(xpresent || ypresent) return false;                                  
        }     
        //else return false
        return false;
    }
}


