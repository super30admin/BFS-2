import java.util.Queue;

// Time Complexity : O(mn)
// Space Complexity: O(mn)

// Approach:
// 1.  Initially count all fresh oranges and append all rotten cells to the queue as level-1
// 2.  Perform BFS and update all cells with neighboring fresh oranges and decrement fresh oranges count. Also increment
//     time for each level traversal.
// 3.  If there are still fresh oranges left by the time queue is empty => not possible and otherwise return the minutes.

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int fresh=0, time=0, m=grid.length, n= grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.add(new int[]{i,j}); // add rotten ones to queue
            }
        }
        if(fresh==0) return 0;
        int[][] dirs = {{0,-1},{-1,0},{1,0},{0,1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                for(int[] dir:dirs) {
                    int r = dir[0]+curr[0];
                    int c = dir[1]+curr[1];
                    if(r >= 0 && r < m && c > 0 && c < n && grid[i][j]==1) {
                        fresh--;
                        grid[r][c] = 2;
                        q.add(new int[]{r,c}); // adding infected ones to queue
                    }
                }
            }
            time++;
        }
        if(fresh>0) return -1;
        return time-1;
    }
}