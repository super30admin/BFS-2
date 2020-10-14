"""
Problem: 994. Rotting Oranges
Leetcode: https://leetcode.com/problems/rotting-oranges/
Time Complexity: O(m*n), m rows and n cols i.e. total numbe rof nodes in the matrix
Space Complexity: O(m*n), in worst case queue can contain all rotten oranges
"""

from collections import deque


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # base case
        if not grid:
            return 0

        queue = deque()

        # Step 1: Build an initial set of rotten oranges
        fresh_oranges = 0
        rows, cols = len(grid), len(grid[0])
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    queue.append((r,c))
                elif grid[r][c] == 1:
                    fresh_oranges += 1

        # if there are all rotten oranges or empty cells, we can return 0 minutes
        if fresh_oranges == 0:
            return 0

        # Step 2: start the rotting process via BFS
        time = -1 # because first iteration starts at 0
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        while queue:
            # to access level elements at each iteration
            qsize = len(queue)
            for i in range(qsize):
                row, col = queue.popleft()
                for dir in directions:
                    x = row + dir[0]
                    y = col + dir[1]
                    # check if index is inside matrix and it is fresh orange
                    if self.is_valid(x, y, grid):
                        grid[x][y] = 2
                        fresh_oranges -= 1
                        queue.append((x,y))
            time += 1
        return time if fresh_oranges == 0 else -1

    def is_valid(self, x, y, grid):
        rows, cols = len(grid), len(grid[0])
        if 0 <= x < rows and 0 <= y < cols and grid[x][y] == 1:
            return True
        return False

