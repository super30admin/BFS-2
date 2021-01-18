# Time Complexity : O(m*n), where m and n are the number of rows and columns respectively in the grid.
# Space Complexity: O(m*n), where m and n are the number of rows and columns respectively in the grid.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
from collections import deque
class Solution(object):
    # This problem will be solved using a bfs approach, where the neighbors
    # of all rotten oranges will be spoilt in one minute and repeating this
    # for the entire array would give the time it takes to rot all fresh oranges.
    def orangesRotting(self, grid):
        if not grid:
            return 0
        fresh, time = 0, 0
        m, n = len(grid), len(grid[0])
        queue = deque()
        # checking all fresh and rotten oranges
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    queue.appendleft((i, j))
        # if all oranges rotten
        if fresh == 0: return 0
        # dirs array for every neighbor
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        # BFS
        while len(queue) != 0:
            size = len(queue)
            # rotting neighbours for all nodes in queue
            for x in range(size):
                curr = queue.pop()
                # checking neighbors
                for i in dirs:
                    r = i[0] + curr[0]
                    c = i[1] + curr[1]
                    # if neighbor exists and is rotten
                    if 0 <= r < m and 0 <= c < n and grid[r][c] == 1:
                        fresh -= 1
                        grid[r][c] = 2
                        queue.appendleft((r, c))
            # after processing one complete level
            time += 1

        if fresh > 0:
            return -1
        return time - 1
