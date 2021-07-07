'''
Solution:
1.  Initially count all fresh oranges and append all rotten cells to the queue as level-1
2.  Perform BFS and update all cells with neighboring fresh oranges and decrement fresh oranges count. Also increment
    time for each level traversal.
3.  If there are still fresh oranges left by the time queue is empty => not possible and otherwise return the minutes.

Time Complexity: O(m x n) and Space Complexity: O(m x n)
'''

from collections import deque


class RottingOranges(object):

    def __isValidCell(self, r, c, rows, cols, grid):
        #   check whether the cell is valid and also contains a fresh orange
        if (r >= 0 and r < rows and c >= 0 and c < cols and grid[r][c] == 1):
            return True
        return False

    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        #   edge case check
        if (grid == None or len(grid) == 0):
            return 0

        #   calculate number of rows and columns
        rows = len(grid)
        cols = len(grid[0])

        #   initialize fresh count, time and queue
        fresh = 0; time = 0; queue = deque([])

        #   update fresh count and queue accordingly
        for r in range(rows):
            for c in range(cols):
                if (grid[r][c] == 1):   fresh += 1
                if (grid[r][c] == 2):   queue.append([r, c])

        #   do a BFS on entire matrix
        while (len(queue) > 0):

            size = len(queue); time += 1        #   increment time for every level

            for i in range(size):
                cell = queue.popleft()

                dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

                for direction in dirs:
                    r = cell[0] + direction[0]; c = cell[1] + direction[1]
                    #   if valid cell, then decrement fresh count, push the cell to the queue and update the cell's value
                    if (self.__isValidCell(r, c, rows, cols, grid)):
                        grid[r][c] = 2
                        queue.append([r, c])
                        fresh -= 1

        #   if fresh oranges still exist, then not possible and return -1
        if (fresh > 0):
            return -1

        #   return time - 1 (1 extra minute for last level) if time > 0 and otherwise 0.
        return time - 1 if time > 0 else 0

