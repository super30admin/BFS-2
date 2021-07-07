from typing import List
from collections import deque


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        """
            https://leetcode.com/problems/rotting-oranges/
            // Time Complexity : O(mn)
            // Space Complexity : O(mn)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                - Add initial rotten oranges to queue, count fresh oranges
                - Level order traversal (Multi Origin BFS)
                - For each fresh orange neighbour to the rotten orange
                        - change it to a rotten orange
                        - add it to the queue (because its rotten now and its time for it
                            to rot the other oranges)
                        - decrease fresh orange count
        """
        rows = len(grid)
        cols = len(grid[0])

        # edge case
        if not grid or not rows: return 0

        # calculating initial fresh oranges and
        # adding rotten oranges to queue because its
        # time for the rotten oranges to rot the fresh oranges
        fresh = 0
        queue = deque()

        for row in range(rows):
            for col in range(cols):
                # rotten orange, add to queue
                if grid[row][col] == 2:
                    queue.append((row, col))
                # fresh orange
                elif grid[row][col] == 1:
                    fresh += 1

        # no fresh oranges, all are rotten
        # nothing to rot, so time taken is zero
        if fresh == 0: return 0

        # time taken to rot
        time = 0

        #       Right    Left       Up     Down
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]

        while queue:
            # current level
            size = len(queue)
            # for each rotten orange in that level
            for i in range(size):
                rotten = queue.popleft()
                # change all adjacent fresh oranges to rotten
                for dir in dirs:
                    row = dir[0] + rotten[0]
                    col = dir[1] + rotten[1]
                    # was fresh but now rotten
                    if (row >= 0 and row < rows) and (col >= 0 and col < cols) and grid[row][col] == 1:
                        grid[row][col] = 2
                        queue.append((row, col))
                        fresh -= 1
            # time taken to rot including level
            time += 1
            # no fresh orange left, time taken to rot until this level
            if fresh == 0: return time
        # we still have fresh oranges, these are not yet rot
        return -1


if __name__ == '__main__':
    s = Solution()
    print(s.orangesRotting([
        [2, 1, 0, 0],
        [0, 1, 1, 1],
        [0, 1, 0, 1],
        [0, 0, 2, 1]
    ]))
