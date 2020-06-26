// Time Complexity: O(m*n)
// Space Complexity: O(m*n) -> when all oranges are rotten so all are added to the queue

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int fresh = 0 ; int time = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length ; int n = grid[0].length;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1)
                    fresh++;
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1,0}};

        if(fresh == 0) return 0;

        while(!q.isEmpty()){
            int size = q.size(); // as we need to calculate the time at each level
            for(int i = 0 ; i < size ; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                        grid[r][c] = 2 ; fresh--; //make that orange rotten and decrease fresh count;
                        q.add(new int[]{r,c});
                    }
                }
            }
            time++;
        }
        if(fresh > 0) return -1;
        return time - 1;

    }
}
