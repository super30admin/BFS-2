
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) == 0:
            return -1
        m = len(grid)
        n = len(grid[0])
        print(m,n)
        q = deque()
        fresh,time = 0, 0
        for i in range(m):
            for j in range(n):
                if (grid[i][j] == 1):
                    fresh += 1
                if grid[i][j] == 2:
                    q.append((i,j))
                    dirs = [(0, 1), (0, -1), (-1, 0), (1, 0)]
        if fresh == 0:return 0
        while q:
            s = len(q)
            for k in range(s):
                x, y = q.popleft()
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if 0<=nx<m and 0<=ny<n and grid[nx][ny] == 1:
                        grid[nx][ny] = 2
                        fresh-=1
                        q.append((nx,ny))
            time+=1
            if fresh == 0 :
                return time
        return -1
                
