// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	

// Your code here along with comments explaining your approach

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int min = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : directions) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >=0 && x < n && y >= 0 && y < m && grid[x][y] == 1 && !visited[x][y]) {
                        q.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            if (q.size() != 0) {
                min++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    return -1;
                }
            }
        }
        return min;
    }
}