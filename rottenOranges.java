// Time Complexity :O(m+n)
// Space Complexity :O(m+n) m-row length n-column length
// Did this code successfully run on Leetcode :yes
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return -1;
        int m=grid.length; int n=grid[0].length;
        int fresh=0; int time=0;
        Queue<int []> q=new LinkedList<>();
        for(int i=0;i<m;i++) //Time Complexity here: O(mn)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }
        
        if(fresh==0) return 0;
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty() && fresh>0)
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] temp=q.poll();
                for(int[] dir:dirs)
                {
                    int r=dir[0]+temp[0];
                    int c=dir[1]+temp[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1)
                    {
                        grid[r][c]=2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
                
            }
          time++;
        }
        
        if(fresh>0) return -1;
        
        return time;
    }
}