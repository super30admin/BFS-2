// Time Complexity : O(m*n), where m is the number of rows and n is the number of columns in the grid
// Space Complexity : O(m*n), where m is the number of rows and n is the number of columns in the grid (space required for the queue)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain english
//1. Intially count all the fresh oranges in the grid and start BFS by putting all the rotten oranges in the queue
//2. Maintain a size variable to process all the oranges at one level before moving to the next level. Keep putting oranges 
        //in the queue that become rotten (decrease the fresh orange count)and  Increment the time by 1 after processing one level
//3. In the end return -1 if any fresh oranges are remaining OR return time -1 (as we are increasing the time after each level,
        //the time is also incremented after processing the last level so decrease the time by 1 )

// Your code here along with comments explaining your approach

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        //queue to maintain oranges at one level to be proceesed
        Queue<int[]> q = new LinkedList<>();
        //check how many fresh oranges are there in the grid initially
        //simultaneously add any rotten oranges in the queue to be processed
        for(int i =0; i< m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }
        int time = 0;
        if(fresh ==0) return 0;
        int [][]dirs = {{0,1}, {-1,0}, {0, -1}, {1,0}};
        while(!q.isEmpty()){
            //maintain the size variable to maintain all oranges at one level
            int size = q.size();
            for(int i=0; i<size; i++){
                int []curr = q.poll();
                //check all four neighbours of an orange
                for(int[] dir: dirs){
                    int r = dir[0]+curr[0];
                    int c = dir[1]+curr[1];
                    //check if the neighbour is in bounds and is a fresh orange
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c] ==1){
                        //if yes, make it rotten and add to the queue, also decrease the fresh oranges count
                        q.add(new int[]{r,c});
                        grid[r][c] = 2;
                        fresh--;
                    } 
                }
            }
            //for each level increment the time by 1
            time++;
        }
        //in the end check if there no fresh oranges
        if(fresh > 0) return -1;
        //since we are incrementin the time for each level, reduce the time by 1 for the last level
        return time-1;
    }
}