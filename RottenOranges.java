/*
Time complexity: O(MxN) where M is grid row length and N is grid column length
Space: O(MxN) 
Algorithm:
=========
1. Add all rotten oranges to queue initially and find  total number of fresh oranges
2. Queue size so far is considered next level. Iterate through that level
3. Poll every rotten orange's place and update its neighbors' fresh orange to rotten and add rotten oranges to queue, decrement fresh
4. Do this till queue is empty. If fresh is still > 1, some oranges cannot be rotten.
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0 ; i < rows; i++) {        
            for(int j = 0 ; j < cols; j++) {
                if(grid[i][j] == 1) fresh++;            // update number of fresh oranges initially
                else if(grid[i][j] == 2)                // add all cells with rotten oranges to queue
                    q.add(new int[]{i,j});
            }
        }
        if(fresh == 0) return 0;                        // if fresh is 0, every orange in the grid is rotten
        int time = 0; 
        int[][] dirs = new int[][]{ {-1,0} , {0,-1} , {1,0} , {0,1}};       
        while(!q.isEmpty()) {                           // Start with initially rotten oranges 
            int size = q.size();                
            for(int i = 0; i < size; i++) {             // all current rotten oranges have to be processed at t, so iterate through q till i == size
                int[] curr = q.poll();
                for(int[] dir: dirs) {
                    int r = dir[0] + curr[0];           
                    int c = dir[1] + curr[1];
                    
                    if(r >= 0 && c >= 0 && r< rows && c< cols && grid[r][c] == 1) {
                        fresh--;                               // decrement fresh count
                        grid[r][c] = 2;                     // At time t+1, all of rotten oranges' fresh neighbors are rotten, update value
                        q.add(new int[]{r,c});              // add new rotten orange to queue
                    }
                }
            }
            time++;
        }
        
        return fresh != 0?-1: time - 1;                 
    }
}