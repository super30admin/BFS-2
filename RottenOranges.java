// Time Complexity: O(m x n)
// Space COmplexity: O(mx n)
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int count_fresh = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }

        if(count_fresh == 0) {
            return 0;
        }

        int[][] dirs = new int[][] {{0, -1},{1, 0}, {0, 1}, {-1, 0}};
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            for(int i=0; i<size; i++) {
                int[] pos = q.poll();
                for(int[] dir: dirs){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if(x<0 || x >= grid.length || y<0 || y>=grid[0].length || grid[x][y] == 0 || grid[x][y]==2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                    count_fresh--;
                }
            }
        }
// Why count - 1?Because in BFS's last iteration all oranges would have been rotten. So we need to exclude that.
        return count_fresh == 0 ? count - 1: -1;
    }
}