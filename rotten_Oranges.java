Time Complexity: O(mxn)
Space Complexity: O(mxn)


class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length ==0)
            return -1;
        
        int n = grid[0].length;
        int m = grid.length;
        int fresh =0;
        Queue<int []> q = new LinkedList<>();
        //keeping the count of fresh and adding all the rotten oranges inside the queue
        for(int i=0; i<m; i++)
        {
           for(int j=0; j<n; j++) 
           {
               if(grid[i][j]==1)
                   fresh++;
               if(grid[i][j]==2)
                   q.add(new int[] {i,j});
           }
        }
        
        if(fresh == 0) return 0;
        int time=0;
        int[][] dirt = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                int[] curr = q.poll();
                for(int [] d : dirt)
                {
                    int row = d[0] + curr[0];
                    int col = d[1] + curr[1];
                    if(row >=0 && row < m && col >=0 && col < n && grid[row][col] == 1)
                    {
                        grid[row][col] = 2;
                        fresh --;
                        q.add(new int[] {row,col}); 
                    }
                       
                }
                
            }
            time++;
        }
        
        if(fresh > 0) return -1;
        return time > 0 ? time-1 : 0;
    }
}
