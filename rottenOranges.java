// Time Complexity : O(m*n) where m and n are the dimensions of the grid
// Space Complexity : O(m*n) where m and n are the dimensions of the grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS using queue

class rottenOranges {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int time = 0, fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }
        if (fresh == 0) return 0;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] rottenLoc = q.poll();
                for (int[] dir : dirs) {
                    int row = rottenLoc[0] + dir[0];
                    int col = rottenLoc[1] + dir[1];
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        fresh--;
                        q.add(new int[] {row, col});
                    }
                }    
            }
            time++;
        }
        if (fresh > 0) return -1;
        return time > 0 ? time - 1 : 0;
    }
}