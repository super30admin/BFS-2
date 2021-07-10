
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        int R=0,C=0;
        if(grid.length!=0)
        {
            R= grid.length;
            C=grid[0].length;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        Map<Integer,Integer> time= new HashMap<>();
        for(int i = 0 ;i<R;i++)
        {
            for(int j =0;j<C;j++)
            {
                if(grid[i][j]==2)
                {
                    int orange = i*C+j;
                    q.add(orange);
                    time.put(orange,0);
                }
            }
        }
        int output = 0;
        while(!q.isEmpty())
        {
            int orange = q.poll();
            int r = orange/C,c=orange%C;
            Iterator<Integer> neighbours = neighbour(grid,R,C,r,c).iterator();
            while(neighbours.hasNext())
            {
                Integer n = neighbours.next();
                int nr = n/C,nc=n%C;
                grid[nr][nc]=2;
                int norange=nr*C+nc;
                q.add(norange);
                time.put(norange,time.get(orange)+1);
                output=time.get(norange);   
            }
          
        }
        for(int i = 0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return output;
        
    }
      public List<Integer> neighbour(int[][] grid,int R, int C,int r,int c)
    { 
          List<Integer> n = new ArrayList<>();
           int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
          for(int[] dir:dirs)
          {
              int i = r+dir[0];
              int j = c+dir[1];
              if(i<R && i >=0 && j<C && j >=0 )
              {
                  if(grid[i][j]==1)
                  {
                      n.add(i*C+j);
                  }
              }
          }
         
          return n;
    }
}

