// Time Complexity : O(N*M) N * M is the dimension of the grid
// Space Complexity : O(W), with BFS, we convert this problem into tree problem and w is the width of tree,
// where maximum nodes at the leaf level can be stored in the queue(additional space)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// In this problem, we have to find the minutes after which all the fresh oranges in the grid get rotten. We have to first
// find all the oranges(i,j value) that are rotten and that are fresh. If the fresh oranges are 0 that means all oranges are already rotten.
// Else, we can keep all the rotten oranges in a queue, we can find all the neighbor fresh oranges that are going to get rot in next level and
// add them to the queue and increment the minute by 1. After adding fresh oranges count is reduced. Once all oranges(cells) are visited, if the fresh count
// is 0 then we return the minutes else return -1. -1 as not all oranges can be rotten.

import java.util.Queue;
import java.util.LinkedList;

public class RottingOranges {
    int[][] directions = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        Queue<int[]> rottenOranges = new LinkedList<>();

        int freshOrangeCount = separateFreshAndRottenOranges(grid, rottenOranges);
        if (rottenOranges.size() == 0 && freshOrangeCount > 0) return -1;
        if (freshOrangeCount == 0) return 0;

        return getMinutesCount(grid, freshOrangeCount, rottenOranges);
    }

    public int getMinutesCount(int[][] grid, int freshOrangeCount, Queue<int[]> rottenOranges) {
        int minutesCount = -1;

        while (!rottenOranges.isEmpty()) {
            int currentRottenOranges = rottenOranges.size();

            while (currentRottenOranges > 0) {
                int[] rotten = rottenOranges.poll();
                for (int[] dir : directions) {
                    int currentX = rotten[0] + dir[0];
                    int currentY = rotten[1] + dir[1];
                    if (notWithinBounds(currentX, currentY, grid)) {
                        if (grid[currentX][currentY] == 1) {
                            freshOrangeCount--;
                            grid[currentX][currentY] = 2;
                            rottenOranges.add(new int[]{currentX, currentY});
                        }
                    }

                }

                currentRottenOranges -= 1;
                if (currentRottenOranges == 0) {
                    minutesCount += 1;
                }
            }

        }

        if (freshOrangeCount > 0) {
            return -1;
        }
        return minutesCount;
    }

    public int separateFreshAndRottenOranges(int[][] grid, Queue<int[]> rottenOranges) {
        int freshOrangeCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshOrangeCount++;
                } else if (grid[i][j] == 2) {
                    rottenOranges.add(new int[]{i, j});
                }
            }
        }
        return freshOrangeCount;
    }

    public boolean notWithinBounds(int currentX, int currentY, int[][] grid) {
        int row = grid.length, col = grid[0].length;

        if (0 > currentX || 0 > currentY) return false;
        if (row <= currentX || col <= currentY) return false;
        return true;
    }

}
