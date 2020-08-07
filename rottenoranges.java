//time complexity:O(m*n)
//space complexity:O(m*n) // if all oranges are rotten in the beginning and there is no gresh orange, queue will have all oranges in the grid
/*Approach 
-going through the matrix to count number of fresh ornages and store coordinates of rotten ones in the queue
-taking size of the queue and processing elements one by one i.e taking rotten orange and making its neighbours
rotten per iteration while keeping a count(time)
-As soon as a coordinate represents rotten orange we put it in the queue so that it is processed in the next
iteration
-at last if fresh orange count is 0 we will return time else -1
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return -1;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>(); // we will be adding rotten oranges inside the queue
        for(int i=0;i<grid.length;++i)     
        {
            for(int j=0;j<grid[0].length;++j)s
            {
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }
        if(fresh==0) return 0; 
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}}; //all four directions a rotten oranges can infect
        int time = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;++i)
            {
                int[] curr = q.poll();
                for(int[] dir: dirs)
                {
                    int neigh_row_index = curr[0] + dir[0];
                    int neigh_col_index = curr[1] + dir[1];
                    //we need to check if these coordinates are out of bounds
                    if(neigh_row_index<grid.length && neigh_col_index<grid[0].length && neigh_row_index>=0 && neigh_col_index>=0)
                    {
                        if(grid[neigh_row_index][neigh_col_index]==1)
                        {
                            fresh--;
                            q.add(new int[]{neigh_row_index,neigh_col_index});
                            grid[neigh_row_index][neigh_col_index] = 2;
                        }
                    }
                    
                }
            }
            time++; //Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
        }
        if(fresh!=0) return -1;
        return time-1;
    }
}