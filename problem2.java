//Time: O(N)
//Space:O(N)

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int minutes = 0;
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (fresh == 0)
                return minutes;

            minutes++;

            for (int i = 0; i < size; i++) {
                int front[] = queue.poll();

                for (int dir[] : dirs) {
                    int r = dir[0] + front[0];
                    int c = dir[1] + front[1];

                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                        queue.add(new int[] { r, c });
                        grid[r][c] = 2;
                        fresh--;
                    }
                }
            }
        }
        if (fresh > 0)
            return -1;
        return minutes;
    }
}