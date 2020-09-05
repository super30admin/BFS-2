//time complexity O(m x n)
//space complexity O(m xn)
//APPROACH: BFS

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        if(grid == null || grid.length == 0) return -1;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length; int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //adding rotten oranges to q for processing together
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                } else if(grid[i][j] == 1){//counting fresh oranges
                    fresh++;
                }
            }
        }
        //edge case return 0 if no fresh oranges
        if(fresh == 0) return 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r < m && r >= 0 && c < n && c >= 0 && grid[r][c] == 1){
                        grid[r][c] = 2;
                        fresh--;
                        q.add(new int[]{r, c});
                    }
                }
            }
            time++;
        }
        //time - 1 because it overshoots by one in the final check
        if(fresh == 0) return time -1;
        return -1;
    }
}
