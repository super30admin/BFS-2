package com.ds.rani.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenTomatoes {

    //approach: Using BFS to solve this problem.
    // The intution behind using BFS is that I can solve this problem by visiting level by level
    // and calculate the time without much difficulties

    //time complexity:o(n) where n is (rows*columns)
    //Space complexity:

    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        //queue to store the cell values whose elemnt is 2 or rotten
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        //count fresh oranges and store rotten oranges in queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    freshCount++;
                //add rotten tomatoes location in queue
                if (grid[i][j] == 2)
                    q.add( new int[]{i, j} );
            }
        }

        //if there is no fresh orange in grid then return 0 because in 0 time all tomatoes are rotten
        if (freshCount == 0) return 0;
        int time = 0;

        //Now my queue has a elements which can be processed now
        while (!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                int[] currCell = q.remove();
                //now visit 4 neigbours of current cell
                for (int i = 0; i < dirs.length; i++) {
                    int[] dir = dirs[i];
                    int r = currCell[0] + dir[0];
                    int c = currCell[1] + dir[1];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add( new int[]{r, c} );
                        freshCount--;
                    }
                }
            }
            time++;
        }
        if (freshCount == 0) return time - 1;
        return -1;

    }
}
