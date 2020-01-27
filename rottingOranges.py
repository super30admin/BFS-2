"""
Time Complexity : orangesRotting_BFS - O(mn)
Space Complexity : orangesRotting_BFS - O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

from queue import Queue

class Solution:
    def orangesRotting(self, grid):
        if not grid or len(grid) == 0:
            return -1
        
        m = len(grid)
        n = len(grid[0])
        q = Queue()
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.put([i, j])
        
        mins = -1
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                idx = q.get()
                print(idx[0], idx[1])
                for d in dirs:
                    r = idx[0] + d[0]
                    c = idx[1] + d[1]
                    if r >= 0 and r <= m-1 and c >= 0 and c <= n-1 and grid[r][c] == 1:
                        grid[r][c] = 2
                        q.put([r, c])
                        
            mins += 1
            
        return mins
    
s = Solution()
print(s.orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))