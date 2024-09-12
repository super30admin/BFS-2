/**
Problem: Rotten Oranges
Did it run on LeetCode : Yes

Time Complexity: O(m*n), where m is the number of rows n is the number of columns of the grid.
Space Complexity : O(n), where n is oranges.

Approach : BFS.
1. We keep track of fresh and rotten oranges.
2. Since the neighbors of rotten oranges also get rotten, we keep track of them with the help of directions.
3. We now keep adding these neighbors to our queue, and process. At the end of each level, we keep adding to the time value.
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n ; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
            }
        }
        if(fresh == 0) {
            return 0;
        }
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i< size; i++) {
               int[] curr = q.poll();
                for(int[] dir : directions) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == 1) {
                    grid[r][c] = 2;
                    fresh--;
                    q.add(new int[]{r,c});
                }
            }
        }
        time++;
        }
       if(fresh != 0) {
           return -1;
       }          
    return time-1;
    }
}