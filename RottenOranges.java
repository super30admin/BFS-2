//Time complexity: O(MxN) where M is grid row length and N is grid column length
//Space: O(MxN) 


class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        Queue<int []> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0; // to keep the count of fresh oranges initially
        for(int i=0; i < row; i++)
        {
            for(int j=0; j < col; j++)
            {
                if(grid[i][j] == 1)
                {
                    fresh++;
                }
                else if(grid[i][j] == 2) // if not fresh then add it to the queue
                {
                    q.add(new int []{i,j});
                }
            }
        }
        if(fresh == 0) return 0;
         int minutes = 0;
        int[][] dirs = new int[][]{ {-1,0} , {0,-1} , {1,0} , {0,1}};   
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int [] curr = q.poll();
                for(int [] dir : dirs)
                {
                    int r = curr[0] + dir[0]; //check in all directions using dirs array
                    int c = curr[1] + dir[1];
                     if(r >= 0 && c >= 0 && r< row && c< col && grid[r][c] == 1) {
                        fresh--;                               
                        grid[r][c] = 2;                     
                        q.add(new int[]{r,c});              
                    }
                }
            }
            minutes++;
        }
        return fresh !=0 ? -1 : minutes - 1;
    }
}