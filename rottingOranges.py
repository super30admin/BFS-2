"""
Time complexity: O(M * N)
Space complexity: O(M * N)
Compiled on leetcode: Yes
Difficulties faced: No
"""
from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        freshOrangeCount = 0
        dirs = [(1,0), (-1, 0), (0, -1), (0, 1)]
        time = 0
        m = len(grid)
        n = len(grid[0])
        queue = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append((i,j))
                if grid[i][j] == 1:
                    freshOrangeCount += 1
        if freshOrangeCount == 0:
            return 0
        
        while queue:
            size = len(queue)
            for i in range(size):
                currentIndex = queue.popleft()
                for dir in dirs:
                    r = dir[0] + currentIndex[0]
                    c = dir[1] + currentIndex[1]
                    if r >=0 and r < m and c >=0 and c < n and grid[r][c] == 1:
                        freshOrangeCount -= 1
                        grid[r][c] = 2
                        queue.append((r,c))
            time += 1 
        if freshOrangeCount > 0:
            return -1
        return time - 1   