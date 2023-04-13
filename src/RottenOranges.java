import java.util.LinkedList;


// ******************** BFS Approach ********************

public class RottenOranges {
    class Solution {
        private static final int EMPTY = 0, FRESH = 1, ROTTEN = 2;
        private static final int[][] directions = {
                {0, -1},   // LEFT
                {0, 1},    // RIGHT
                {1, 0},    // DOWN
                {-1, 0}    // UP
        };
        public int orangesRotting(int[][] grid) {
            Queue<Pair<Integer, Integer>> q = new LinkedList<>();
            int m = grid.length, n = grid[0].length;
            int fresh = 0;                                                   // maintaining fresh oranges count
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(grid[i][j] == ROTTEN) {                               // adding all rotten oranges in queue
                        q.add(new Pair(i, j));
                    }
                    else if(grid[i][j] == FRESH) {                           // maintaining fresh oranges count
                        fresh++;
                    }
                }
            }
            if(fresh == 0)
                return 0;
            int time = 0;                                                    // maintaining time variable
            while(!q.isEmpty()) {
                Queue<Pair<Integer, Integer>> next = new LinkedList<>();
                while(!q.isEmpty()) {
                    Pair<Integer, Integer> pair = q.remove();                // getting rotten oranges' coordinates from queue one by one
                    for(int[] dir : directions) {
                        int x = pair.getKey() + dir[0];           
                        int y = pair.getValue() + dir[1];
                        if(x>=0 && x<m && y>=0 && y<n) {                     // check bounds for coordinates
                            if(grid[x][y] == FRESH) {                        // if orange is fresh
                                grid[x][y] = ROTTEN;                         // make it rotten
                                fresh--;                                     // decrement fresh count
                                next.add(new Pair(x, y));                    // storing next level coordinates in queue
                            }
                        }
                    }
                }
                q = next;
                time++;                                                      // increment time variable
            }
            return fresh > 0 ? -1 : time-1;                                  // if any fresh orange left, return -1; o else time-1 as it would have been incremented n last iteration
        }
    }
}


// ******************** DFS Approach ********************
// class Solution {
//     private static final int EMPTY = 0, FRESH = 1, ROTTEN = 2;
//     private static final int[][] directions = {
//         {0, -1},   // LEFT
//         {0, 1},    // RIGHT
//         {1, 0},    // DOWN
//         {-1, 0}    // UP
//     };
//     public int orangesRotting(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int max = 0;
//         if(grid == null || grid.length == 0)
//             return -1;
//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(grid[i][j] == ROTTEN) {                                  // running dfs for all rotten oranges
//                     dfs(grid, i, j, 2);
//                 }
//             }
//         }
//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(grid[i][j] == FRESH)                                     // if any fresh orange left after dfs applied
//                     return -1;
//                 else if(grid[i][j] != EMPTY)                                
//                     max = Math.max(max, grid[i][j] - 2);                    // updating max
//             }
//         }
//         return max;
//     }
//     private void dfs(int[][] grid, int i, int j, int time) {
        
//         if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return;       // handling out of bound
//         else if(grid[i][j] != FRESH && grid[i][j] < time) return;           // if fresh orange is updated and this way is longer than any other way
        
//         grid[i][j] = time;                                                  // update oranges with time
        
//         for(int[] dir: directions) {
//             int newI = i + dir[0];
//             int newJ = j + dir[1];
//             dfs(grid, newI, newJ, time+1);                                  // recursive dfs
//         }
//     }
// }
