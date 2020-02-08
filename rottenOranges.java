class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        if(grid==null || grid.length==0) return 0;
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    fresh++;
                if(grid[i][j]==2)  
                    q.add(new int[]{i,j});
            }
        }
        int time=0;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] rotten=q.poll();
                for(int[] dir:dirs)
                {
                    int r=rotten[0]+dir[0];
                    int c=rotten[1]+dir[1];
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
        return time>0 ? time-1 : 0;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)