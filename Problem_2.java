/*
 * Time Complexity : O(m*n)
 * Space Complexity : O(m*n)
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid.length == 0){
            return 0;
        }
        
        Queue<int[]> queue = new LinkedList<int[]>();
        int fresh = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
                
            }
        }
        
        if(fresh == 0){
            return 0;
        }
        
        int result = 0;
        int dir[][] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                int[] pos = queue.poll();
                
                for(int j=0; j<dir.length; j++){
                    int r = dir[j][0] + pos[0];
                    int c = dir[j][1] + pos[1];
                    
        //            System.out.println(r + " : "+c);
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        queue.add(new int[]{r, c});
                    }
                }
            }
            
            result++;
        }
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                    
                }
            }
        }
        
        return result-1;
    }
}