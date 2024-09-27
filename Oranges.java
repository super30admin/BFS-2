// Time Complexity :O(N^N)
// Space Complexity :O(M x N) M = length of queue and N = length of directions array
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. We would store the row and column values of the rotten oranges and traverse it's neighboring elements
//2. and check for fresh oranges. If there are fresh oranges we rot them and minutes is increased.
import java.util.*;

public class Oranges {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getKey() {
            return this.row;
        }

        public int getValue() {
            return this.col;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                else if (grid[i][j] == 2)
                    q.add(new Pair(i, j));

            }
        }
        int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int mins = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            if (fresh == 0)
                return mins;
            mins++;

            for (int i = 0; i < qSize; i++) {
                Pair p = q.poll();
                int x = p.getKey();
                int y = p.getValue();
                for (int[] dir : dirs) {
                    int r = x + dir[0];
                    int c = y + dir[1];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new Pair(r, c));
                        fresh--;
                    }
                }
            }
        }

        if (fresh > 0)
            return -1;
        return mins;
    }

    public static void main(String args[]) {
        Oranges obj = new Oranges();
        int[][] or = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(obj.orangesRotting(or));

    }
}
