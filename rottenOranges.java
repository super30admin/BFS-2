/* Time complexity: O(m*n); where m is the number of rows and n is the number of columns
space complexity: O(x); x is the number of elements in grid, as we are using queue.
*/

class Solution{
    public int orangesRotting(int[][] grid){
        //base
        if(grid == null || grid.length == 0) return 0;
        int fresh = 0;
        Queue<int []> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) q.add(new int[] {i,j});
            }
        }

        if(fresh == 0) return 0;
        int[][] dir = {{1,0}, {0,1}, {0,-1}, {-1,0}};
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int[] d : dir){
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    if(r > 0 && r < grid.length && c > 0 && c < grid[0].length && grid[r][c] == 1){
                        grid[r][c] = 2; fresh--;
                        q.add(new int[][] {r,c});
                    }
                }
            }
            time ++;
        }
        if(fresh != 0) return -1;
        return time-1;
    }
}