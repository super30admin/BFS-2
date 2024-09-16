#LC 994 - Rotting Oranges
#Time Complexity - O(m*n)
#Space Complexity - O(m*n)
from collections import deque
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        def isValid(x,y):
            return x >=0 and y >= 0 and x < len(grid) and y < len(grid[0]) and grid[x][y] == 1
        if not grid:
            return 0
        
        fresh = 0
        q = deque()
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    q.append([i,j])
                elif grid[i][j] == 1:
                    fresh = fresh + 1
        if fresh == 0:
            return 0
        level = -1
        dirs = [[-1,0],[1,0],[0,1],[0,-1]]
        while q:
            l = len(q)
            for i in range(l):
                x,y = q.popleft()
                for d in dirs:
                    r = x + d[0]
                    c = y + d[1]
                    if isValid(r,c) == True:
                        q.append([r,c])
                        fresh = fresh - 1
                        grid[r][c] = 2
            level = level + 1
        return level if fresh == 0 else -1