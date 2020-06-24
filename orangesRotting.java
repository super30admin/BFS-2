// Time Complexity : O(m*n) m and n are rows and columns of grid
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList<>();
        int minutes = -1;
        int time = 0;
        int fresh=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
                
                if(grid[i][j]==1)
                    fresh++;
            }
        
        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        if(fresh==0) return 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size!=0)
            {
                int[] square = queue.poll();
                for(int[] dir:dirs)
                {
                    int r = square[0]+dir[0];
                    int c = square[1]+dir[1];
                    if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==1)
                    {
                        grid[r][c] = 2;
                        fresh--;
                        queue.add(new int[]{r,c});
                    }
                }
                size--;
            }
            minutes++;
        }
        
        if(fresh>0) return -1;
        else
            return minutes;
        
    }
}