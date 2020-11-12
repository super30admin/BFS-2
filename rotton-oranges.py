class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if grid == None or len(grid) == 0:
            return 0
        from collections import deque
        q = deque()
        fresh = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    q.append((i, j))

        dirs = ((0, 1), (1, 0), (-1, 0), (0, -1))
        if fresh == 0:
            return 0
        time = 0
        while q:

            length = len(q)
            for i in range(length):
                popp = q.popleft()
                for dir in dirs:
                    x = popp[0] + dir[0]
                    y = popp[1] + dir[1]
                    if x >= 0 and x < len(grid) and y < len(grid[0]) and y >= 0 and grid[x][y] == 1:
                        grid[x][y] = 2
                        fresh -= 1
                        q.append((x, y))

            time += 1
        if fresh > 0:
            return -1
        return time - 1
# time and spaceO(nm)