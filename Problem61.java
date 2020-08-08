Time Complexity - O(N)
Space Complexity - O(N)

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length<1) return 0;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        
        int fresh = 0;
        Queue<int[]> q = new LinkedList();
        for(int i =0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(grid[i][j] == 1) fresh++; 
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }
        
        if(fresh == 0) return 0;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                int[] cur = q.poll();
                for(int[] dir : directions){
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==1){
                        grid[r][c] = 2;
                        fresh--;
                        q.offer(new int[]{r,c});
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time-1 : -1;
    }
}