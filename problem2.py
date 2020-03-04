'''
Iterative:
Time Complexity: O(m*n) row*column
Space Complexity: O(m*n)
Did this code successfully run on Leetcode : Yes
Explanation: Use BFS to implement, iterate through 2D find oranges which are fresh and add rotten into the queue with
the (row,column) into queue. Increase Time by 1 and iterate through queue and make the oranges around it to rotten.
If in every rotten we see 0 freshOranges then return the timeTicker
'''

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) == 0:
            return 0

        m = len(grid)
        n = len(grid[0])

        queue = []

        # freshOranges
        fresh = 0

        for i in range(0, m):
            for j in range(0, n):
                if grid[i][j] == 1:
                    fresh += 1

                if grid[i][j] == 2:
                    queue.append((i, j))

        # if there are no fresh oranges (all rotten) then return 0
        if fresh == 0:
            return 0

        timeTicker = 0

        # get neighbours cordinates, dx and dy contains delta
        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]

        while len(queue) != 0:
            # at each level how many rotten oranges
            rottenOrangeLevel = len(queue)
            timeTicker += 1
            for i in range(0, rottenOrangeLevel):
                cell = queue[0]
                queue = queue[1:]

                for k in range(0, 4):
                    x = cell[0] + dx[k]
                    y = cell[1] + dy[k]

                    if x >= 0 and x < m and y >= 0 and y < n and grid[x][y] == 1:
                        grid[x][y] = 2
                        fresh -= 1
                        if fresh == 0:
                            return timeTicker
                        queue.append((x, y))

        return -1

