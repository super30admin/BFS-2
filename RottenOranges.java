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

//Time Complexity: O(h * w * (h + w)), where h and w are the dimension of the grid. (h + w) Maximum distance between two cells through all grid cells.
//Space: O(1)

// Referred google for this solution.

//Approach:- First, count fresh oranges.Then, until fresh is non-zero, perform BFS to rot oranges, 
//decreasing fresh. Count days (d) and return it in the end. If, after another day, fresh does not 
//change, return -1. 

class Solution {        
    public int orangesRotting(int[][] g){
      int fresh = 0, d = 0;
      for (int i = 0; i < g.length; ++i)
        for (int j = 0; j < g[i].length; ++j)
          if (g[i][j] == 1)
              ++fresh;
      for (int old_fresh = fresh; fresh > 0; ++d, old_fresh = fresh) {
        for (int i = 0; i < g.length; ++i)
          for (int j = 0; j < g[i].length; ++j)
            if (g[i][j] == d + 2)
              fresh -= rot(g, i + 1, j, d) + rot(g, i - 1, j, d) + rot(g, i, j + 1, d) + rot(g, i, j - 1, d);
        if (fresh == old_fresh) 
            return -1;
      }
       return d;
    }
    
    private int rot(int[][] g, int i, int j, int d){
        if (i < 0 || j < 0 || i >= g.length || j >= g[i].length || g[i][j] != 1)
            return 0;
         g[i][j] = d + 3;
         return 1;
    }
}
}