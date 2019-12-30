//Time Complexity: O(mxn)
// Space complexity: O(mxn)
// Solved on leetcode: Yes
class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        
        if(m==0) return 0;
        int n = grid[0].length;
        
        int fresh =0;
         Queue <int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    fresh ++;
                }
                
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
            }
        }
        if (fresh ==0) return 0;
        
        int count = 0;
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] rotten = q.poll();
                
                for (int[] dir : dirs) {
                    int r = rotten[0] + dir[0];
                    int c = rotten[1] + dir[1];
                    
                    if ( r>=0 && c >=0 && r<m && c<n && grid[r][c] == 1) {
                         grid[r][c] = 2;
                        q.add(new int[] {r,c});
                        fresh --;
                    }
                }   
            }
            count ++;
        }
        if (fresh > 0) return -1;
        
        return count-1;
        
    }
}