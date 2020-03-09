// Time Complexity - O(n) where n is the number of elements in the matrix
// Space Complexity - O(n) where n is the number of elements in the matrix

class Solution {
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length ==0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        int fresh =0;
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i < m;i++){
            for(int j=0;j < n;j++){
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
                if(grid[i][j] == 1)
                    fresh ++;
                
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int k =0 ; k < size;k++){
                int[] rot = q.poll();
                for(int [] dir : dirs){
                    int r = rot[0] + dir[0];
                    int c = rot[1] + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        fresh --;
                        q.add(new int [] {r,c});
                        
                    }
                }    
            }
            time++;
        }
        if(fresh > 0)   return -1;
        return time > 0 ? time-1:0;
    }
}
