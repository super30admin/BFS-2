// Time Complexity : O(n*m), row and column size
// Space Complexity : O(n*m), all oranges are rotten and added to queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Solution : BFS

class Solution {
    public int orangesRotting(int[][] grid) {
        //If grid is empty or length = 0, return 0
        if(grid == null || grid.length == 0) return 0;
        
        //keep count of freshOranges
        int freshOrange = 0;
        //length of row and column
        int m = grid.length;
        int n = grid[0].length;
        //create a int array queue
        Queue<int []> q = new LinkedList<>();
        //iterate through the grid
        //count the number of fresh oranges, increase the freshOrange count
        //and if it is rotten add to queue
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) freshOrange++;
                if(grid[i][j] == 2) q.add(new int[] {i,j});
            }
        }
        //if there are no fresh oranges in grid, return 0 then and there
        if(freshOrange == 0) return 0; 
        //time at start is = 0
        int time = 0; 
        //4-directions array 
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //do while queue is not empty
        while(!q.isEmpty()) {
            //get the size (time increases based on each level)
            int size = q.size();
            for(int i = 0; i < size; i++) {
                //get front of queue
                int[] curr = q.poll();
                //get its 4-directional neighbors
                for(int[] dir : dirs) {
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    //check neighbors boundary condition and check if its fresh 
                    //(we should only rotten fresh oranges)
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        //if fresh, make it rotten and add to queue and decrease fresh count
                        grid[r][c] = 2;
                        q.add(new int[] {r,c});
                        freshOrange--;
                    }
                }              
            } time++; //after each level time is increased
        } 
        //check for freshOranges count, if > 0, 
        //then all oranges cannot be rotten, then return -1
        if(freshOrange > 0) return -1;
        //else return time-1, as before last iteration in queue, 
        //all oranges are already become rotten
        else return time-1;        
    }
}



