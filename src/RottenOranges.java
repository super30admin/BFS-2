

import java.util.LinkedList;

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
            int fresh = 0;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(grid[i][j] == ROTTEN) {
                        q.add(new Pair(i, j));
                    }
                    else if(grid[i][j] == FRESH) {
                        fresh++;
                    }
                }
            }
            if(fresh == 0)
                return 0;
            int time = 0;
            while(!q.isEmpty()) {
                Queue<Pair<Integer, Integer>> next = new LinkedList<>();
                while(!q.isEmpty()) {
                    Pair<Integer, Integer> pair = q.remove();
                    for(int[] dir : directions) {
                        int x = pair.getKey() + dir[0];
                        int y = pair.getValue() + dir[1];
                        if(x>=0 && x<m && y>=0 && y<n) {
                            if(grid[x][y] == FRESH) {
                                grid[x][y] = ROTTEN;
                                fresh--;
                                next.add(new Pair(x, y));
                            }
                        }
                    }
                }
                q = next;
                time++;
            }
            return fresh > 0 ? -1 : time-1;
        }
    }
}
