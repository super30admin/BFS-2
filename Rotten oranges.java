// Time complexity 0(m*n) no of rows and columns in a grid
// space complexity 0(m*n) no of rows and columns in a grid
// code successfully executed in leetcode.
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        if(grid == null || m == 0) return 0;
        int n = grid[0].length;
        int fresh =0;
        Queue<int []> q1 = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid [i][j]==2) q1.add(new int [] {i,j});
                 if(grid [i][j] == 1) fresh++;    
            }
        }
        //if(fresh == 0) return 0;
        int time =0;
        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q1.isEmpty()){
// going level by level to keep track of it and increase the time as well.
            int size = q1.size();
            for (int i=0;i<size;i++){
              int [] rotten = q1.poll();
               for(int [] dir : directions ){
                   int r = rotten[0]+ dir[0];
                   int c = rotten[1]+ dir[1];
                   if(r >= 0 && r<m && c >= 0 && c<n && grid[r][c] == 1){
                       grid[r][c] = 2;
                       q1.add(new int [] {r,c});
                       fresh--;
                 }
                   
               }  
            }
            time++;   
        }
       if(fresh > 0 ) return -1;
       return time >0 ? time -1:0;
    }
}