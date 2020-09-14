Time Complexity: O(mn)
Space Complexity: O(mn)
Ran successfully on leetcode?: yes

class Solution {
    Queue<Integer[]> q;
    int m, n;
    int time = 0;
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        q = new LinkedList<>();
        m = grid.length;
        n = grid[0].length;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new Integer[]{i,j});
                }
            }
        }
        
        bfsHelper(grid);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time > 0? time - 1: 0;
    }
    
    private void bfsHelper(int[][] grid){
        int size = q.size();
        
        if(size == 0) return;
        
        int[][] dirs = {{0,-1},{0,1},{-1,0}, {1, 0}};
        while(size > 0){
            Integer[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                    grid[r][c] = 2;
                    q.add(new Integer[]{r,c});
                }
            }
            size--;
        }
        time++;
        bfsHelper(grid);
    }
}
