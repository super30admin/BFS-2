class Solution {
    public int orangesRotting(int[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        
        int fresh = 0;
        int time = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        if (fresh == 0) return 0;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while (!q.isEmpty()){
            int size = q.size();
            for (int x = 0; x  <  size; x++){
                 int[] curr = q.poll();
                 for (int[] dir : dirs){
                     int r = dir[0] + curr[0];
                     int c = dir[1] + curr[1];
                     
                     if (r >=0 && r < n && c >=0 && c < m && grid[r][c] == 1 ){
                         grid[r][c] = 2;
                         q.add(new int[]{r,c});
                         fresh--;
                     }
                 }
              
            }
            time++; 
        }
        if (fresh != 0)return -1;
    return time -1;   
    }
    
}