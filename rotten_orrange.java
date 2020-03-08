// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : COuldn't solve before class


// Your code here along with comments explaining your approach
//bfs

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }
        int time = -1;
        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            time++;
            int nodesLevel = q.size();
            for (int node = 0; node < nodesLevel; node++) {
                Pair c = q.remove();
                for (int i = 0; i < 4; i++) {
                    int x = c.x + dx[i];
                    int y = c.y + dy[i];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.add(new Pair(x, y));
                        freshOranges--;
                    }
                }
            }
        }

        if (freshOranges == 0) {
            return time;
        }
        return -1;
    }

}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}