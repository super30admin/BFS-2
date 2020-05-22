//Rotten oranges
//time o(mn) m - no of rows, n - no of cols
//space o(mn)
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        //BFS
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int time = 0, fresh = 0;
        //find the rotten oranges and intialize in queue
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(q.isEmpty() && fresh == 0)
            return 0;
        int[][] dirs ={{1,0},{0,1},{-1,0},{0,-1}};
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();
                for(int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh != 0)
            return -1;
        return time - 1;
    }
}