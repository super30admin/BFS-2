// Time Complexity : O(m*n). m is the number of row and n is the number of columns
// Space Complexity : O(m*n).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q =  new LinkedList();
        int minutes=0;
        int freshOranCount=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    
                }
                 if(grid[i][j]==1){
                    freshOranCount++;
                }
            }
        }
        
        if(freshOranCount==0) return 0;
        int[][] dirs = new int[][]{
                {0,-1},
                {0,1},
                {1,0},
                {-1,0}
            };
        
        while(!q.isEmpty()){
            
            
            int size = q.size();
            for(int f=0;f<size;f++){
                int[] current = q.poll();
            
            for(int i=0;i<dirs.length;i++){
                int[] d = dirs[i];
                int r=d[0]+current[0];
                int c = d[1]+current[1];
                
                if(r>=0 && r<grid.length &&
                  c>=0 && c<grid[0].length && grid[r][c]==1){
                    q.add(new int[]{r,c});
                    grid[r][c]=2;
                    
                   freshOranCount--;
                }
            }  
                
            }
            
            minutes++;
            
           
        }
        
        
            if(freshOranCount!=0)
            return -1;
            return minutes>0?minutes-1:0;
    }
}
