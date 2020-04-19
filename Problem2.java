// Time Complexity: O(m*n)
// Space complexity: O(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        
        // At first need to traverse the grid to get all the rotten oranges positions
        // and insert them in queue. And also get how many oranges are fresh. 
        // process each element in queue and add it's adjacent fresh ones in queue
        // increase time by 1
        
        //edge case
        if(grid == null || grid.length ==0){
            return 0;
        }
        
        Queue<int []> q = new LinkedList<>();
        int fresh = 0; 
        int time = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }
            }
        }
        
        if(fresh == 0){
            return 0;
        }
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new int[] {r,c});
                        fresh--;
                    }
                }
            }        
            time++;
        }        
        
        if(fresh > 0){
            return -1;
        }
        return time-1;
    }
}
