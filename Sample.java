//Cousins of a binary tree
// Time Complexity :0(V+E)
// Space Complexity :0(n)max no. of nodes in a level
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/**
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
import java.util.*; 

class Solution {
    
    int depthx=0;
    int depthy=0;
    TreeNode parentx=null;
    TreeNode parenty=null;
    public boolean isCousins(TreeNode root, int a, int b) {
        if(root==null)
            return false;
        
        recurr(root,a,b,0,null);
        
        if((depthx==depthy)&& (parentx!=parenty))
            return true;
        else
           return false;
    }
    
    private void recurr(TreeNode root, int x, int y, int depth,TreeNode parent)
    {
        if(root==null)
        {
            return;
        }
        if(root.val==x)
        {
             depthx=depth;
            parentx=parent;
        }
        if(root.val==y)
        {
             depthy= depth;
            parenty=parent;
        }
        recurr(root.right,x,y,depth+1,root);
        recurr(root.left,x,y,depth+1,root);
    }
}
//Rotting oranges
// Time Complexity :0(m*n)
// Space Complexity :0(m*n)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/**
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int minutes=0;
        int fresh=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
                if(grid[i][j]==1)
                    fresh+=1;
            }
        }
        
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            if(fresh==0){
            return minutes;
                }
             minutes+=1;
            int size= q.size();
            for(int x=0;x<size;x++)
            {
                int[] front= q.poll();
                for(int[] dirs:directions)
                {
                    int r= front[0]+dirs[0];
                    int c= front[1]+dirs[1];
                    
                    if(r>=0 && r<grid.length && c>=0 && c< grid[0].length && grid[r][c]==1)
                    {
                        q.add(new int[]{r,c});
                        grid[r][c]=2;
                        fresh-=1;
                    }
                }
                
            }
             
            
            
        }
        if(fresh>0)
            return -1;
        return minutes;
    }
}
//Employee Importance
// Time Complexity :0(n)
// Space Complexity :0(n)
//Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no
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
        HashMap<Integer, Employee> hp= new HashMap<>();
        for(Employee emp: employees)
        {
            hp.put(emp.id,emp);
        }
        int output=0;
        Queue<Integer> queue= new LinkedList<>();
        queue.add(id);
        while(!queue.isEmpty())
        {
            int front=queue.poll();
            output+= hp.get(front).importance;
             for(int sub: hp.get(front).subordinates)
                 queue.add(sub);
            
        }
        return output;
    }
}
