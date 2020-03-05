// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Approach: We need to track and increase time when neighboring fresh oranges get rotten. 
// This can be done in a BFS manner. With each increasing level, the timestamp can be increased. 
// When the traversal is complete, if no fresh oranges are left, the time is returned. Otherwise -1 is returned.

class Solution {
    public int orangesRotting(int[][] grid) {
        //edge case
        if(grid == null || grid.length == 0) return -1;
        // maintain a queue to add all rotten oranges
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j}); // adding rotten oranges in queue
                }
                else if(grid[i][j] == 1) {
                    fresh++; // counting fresh oranges
                }
            }
        }
        if(fresh == 0) return 0; // no need to perform any action if there are no fresh oranges
        int time = 0;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // 2-D array to check all 4 directions
        while(!queue.isEmpty()) {
            int size = queue.size();
            time++; // incrementing time at each level
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for(int[] dir: dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2; // converting fresh orange to rotten
                        fresh--;
                        queue.offer(new int[]{x,y}); // adding the newly converted rotten orange to queue
                    }
                }   
            }
        }
        if(fresh > 0) return -1; // if there are fresh oranges left, then return -1
        return time > 0 ? time-1 : 0;
    }
}

