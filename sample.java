// Time Complexity : O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

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
    int x_found ; // to record depth at which x was found
    int y_found ; // to record depth at which y was found
    TreeNode x_parent; TreeNode y_parent; // to keep track of parent of x and y
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null) // if no root 
            return false;
        
        dfs(root,null, 0, x, y); // calling dfs on root for parent null and depth 0
        
        if(x_found == y_found && x_parent != y_parent) // if the depth is same and parents are not
            return true;
        else
            return false;
    }
    
    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y)
    {
        //base
        if(root == null)
            return;
        //logic
        if(root.val == x) // if value at root is either x or y
        {
            x_found = depth; // save the depth at which it was found and its parent
            x_parent = parent;
        }
         if(root.val == y)
        {
            y_found = depth;
            y_parent = parent;
        }
        
        dfs(root.left, root, depth+1, x, y); // call dfs on left branch
        dfs(root.right, root, depth+1, x, y); // call dfs on right branch
           
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) 
            return false;
        
        boolean x_found = false; boolean y_found = false;  // to check if we found x and y at same depth

        Queue<TreeNode> q = new LinkedList<>(); // to process the nodes
        q.add(root); // adding root to queue
        
        while(!q.isEmpty()) // till the queue is not empty
        {
            int size = q.size(); // to process nodes based on levels
            
            for(int i=0; i<size; i++)
            {
                TreeNode curr = q.poll(); // get curr node
                
                if(curr.left != null && curr.right != null) // if left and right child exists
                {
         if((curr.left.val == x && curr.right.val== y) || (curr.left.val == y && curr.right.val == x) )
                    return false; // if both values found as children on same root , return false
                }
               
                if(curr.val == x) // if x found
                    x_found = true;
                if(curr.val == y) // if y found
                    y_found = true;
                
                if(curr.left!=null) // process left children
                    q.add(curr.left);
                if(curr.right!=null) // process right children
                    q.add(curr.right);
            } 
            
            if(x_found && y_found) // if both found at same level and their parents will be diff as checked earlier
                return true;
            if(x_found || y_found) // if only one found means they exist at different levels
                return false;
        }
        return false;
    }
}

// Time Complexity : O(m*n)
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Solution {
    public int orangesRotting(int[][] grid) {
    
        if(grid == null || grid.length ==0) // if no oranges
            return 0; // time taken is 0
    
        Queue<int []> q = new LinkedList<>(); // to process oranges
        
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0; // to keep track of fresh oranges left
        
        for(int i=0;i<m;i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]==2) // adding all rotten oranges to queue 
                    q.add(new int[] {i,j}); 
                
                if(grid[i][j]==1) // if fresh orange, increase fresh count
                    fresh++;
            }
        }
        
        if(fresh == 0) // if no fresh oranges present
            return 0;
        
        int dirs[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}}; // to go to next level
        int time = 0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i=0; i<size; i++)
            {
                int curr[] = q.poll(); // get the current orange to process
                
            for(int dir[]:dirs) // find child or next level oranges
                {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if(r>=0 && c >=0 && r<m && c<n && grid[r][c] == 1) // boundary check and if neighours are fresh
                {
                    fresh--; // decrease count as processed
                    grid[r][c] = 2; // make it rotten
                    q.add(new int[] {r,c}); // add to queue
                }  
                }
               
            }
             time++; // increase time at each level
        }
        
        if(fresh>0) // if fresh oranges left, there is no solution possible
            return -1;
        
        return time - 1; // we go one more than needed so reduce time by 1 and return 
       
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for(Employee e : employees) // putting id and their object corresponding to id in map so that we dont have to traverse the employee list again and again
        {
            map.put(e.id, e);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id); // adding id for which importance has to be found
        
        int value = 0;
        while(!q.isEmpty()) // till queue is not empty
        {
            int curr = q.poll(); //get latest employee out of queue
           
            Employee e = map.get(curr); // get the employee details
            value+= e.importance; // add impoortance to the total value
            
            for(int sub :  e.subordinates) // iterate on the subordinates of the curr employee and add them to queue
            {
                q.add(sub);
            }
        }
        return value;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n) hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map;
    int value;
    public int getImportance(List<Employee> employees, int id) {
       map = new HashMap<>();
        value= 0;
        for(Employee e : employees) // putting id and their object corresponding to id in map so that we dont have to traverse the employee list again and again
        {
            map.put(e.id, e);
        }
        
        dfs(id); // calling dfs on id of employee for which importance has to be found
        return value;
    }
    
    private void dfs(int id)
    {
        //no base as for loop runs till sub are present
        
        //logic
        Employee e = map.get(id); // get employee details
        value+= e.importance; // add its importance to result
        
        for(int sub : e.subordinates) // traverse the subordinates and call dfs on them
        {
            dfs(sub);
        }
    }
}