// Time complexity - O(n)
// Space complexity - O(m*n)

// Apply BFS from rotten orange. Convert fresh orange to rotten and decrease count of fresh oranges.

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int fresh = 0; int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }
        if(fresh == 0) return 0;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && r<m && c>=0 && c < n && grid[r][c] == 1){
                        fresh--;grid[r][c] = 2;
                        q.add(new int[]{r,c});
                    }
                }
            }
            time++;
        }
        if(fresh > 0) return -1;
        return time-1;
    }
}
