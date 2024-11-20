// Time Complexity :
//      N - number of cells
//      total time complexity will be O(N)
//
// Space Complexity :
//      O(N)->at a time there might be all the cells present in the queue in the worst case
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0 , minutes = 0, s = 0;
        if(grid.length==0)
            return 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        if(fresh==0)
            return 0;
        int[][] direction = {{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty())
        {
            s = q.size();
            for(int l = 0; l<s; l++)
            {
                int[] rotten = q.poll();
                for(int[] d:direction)
                {
                    int adj_x = rotten[0]+d[0];
                    int adj_y = rotten[1]+d[1];
                    if(adj_x>=0 && adj_y >=0 && adj_x < grid.length && adj_y < grid[0].length && grid[adj_x][adj_y]==1)
                    {
                         grid[adj_x][adj_y]=2;
                         q.offer(new int[]{adj_x, adj_y});
                         fresh--;
                    }
                }
            }
            minutes++;
        }
        if(fresh>0)
            return -1;
        else
            return (minutes-1);
    }
}