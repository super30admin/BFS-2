//Time complexity: O(MxN) where M is grid row length and N is grid column length
//Space: O(MxN) 

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0 ; i < rows; i++) {        
            for(int j = 0 ; j < cols; j++) {
                if(grid[i][j] == 1) fresh++;            
                else if(grid[i][j] == 2)                
                    q.add(new int[]{i,j});
            }
        }
        if(fresh == 0) return 0;                        
        int time = 0; 
        int[][] dirs = new int[][]{ {-1,0} , {0,-1} , {1,0} , {0,1}};       
        while(!q.isEmpty()) {                           
            int size = q.size();                
            for(int i = 0; i < size; i++) {             
                int[] curr = q.poll();
                for(int[] dir: dirs) {
                    int r = dir[0] + curr[0];           
                    int c = dir[1] + curr[1];
                    
                    if(r >= 0 && c >= 0 && r< rows && c< cols && grid[r][c] == 1) {
                        fresh--;                               
                        grid[r][c] = 2;                     
                        q.add(new int[]{r,c});              
                    }
                }
            }
            time++;
        }
        
        return fresh != 0?-1: time - 1;                 
    }
}