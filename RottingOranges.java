import java.util.*;

//Time complexity: O(N^2)
//Space complexity: O(N)

/**
 * 1. Maintain count of fresh oranges. 
 * 2. for every rotten orange, check its nearby oranges and change them to rotten if they are fresh.
 * 3. It is based on breadth first search. Queue size is maintained in this case since we need to find in
 * how many steps all oranges are rotten. It operates as levelwise traversal.
 */

class RottingOranges {
    public int orangesRotting(int[][] grid) {
     
        if(grid == null || grid.length == 0)
            return 0;
        
        int R = grid.length;
        int C = grid[0].length;
        int freshCount = 0;
        
        Queue<int[]> q = new LinkedList<>(); 
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
                if(grid[i][j] == 1)
                    freshCount++;
            }
        }
        
        if(freshCount == 0)
            return 0;
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;
        
        while(!q.isEmpty()) {
            ++count;   
            
            int size = q.size();
            
            for(int i=0; i<size; i++) {
        
                int[] curr = q.poll();
            
                for(int[] d : dirs) {

                    int nr = d[0] + curr[0];
                    int nc = d[1] + curr[1];

                    if(nr >= 0 && nc >= 0 && nr < R && nc < C && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        freshCount--;
                    }

                }
                
            }
            

        } 
        
        return freshCount == 0 ? count-1 : -1;
        
    }
}