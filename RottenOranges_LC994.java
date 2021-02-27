/* Time: O(m*n)
Space: O(m*n)
m = no of rows; n = noo of columns
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }    
            }
        }
        
        if(fresh == 0) return 0;
        int minutes  = 0;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];

                    if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1){
                        fresh--;
                        grid[row][col] = 2;
                        q.add(new int[]{row, col});
                    } 
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes - 1 : -1;
    }
}