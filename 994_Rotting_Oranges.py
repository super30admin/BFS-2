from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:return 0
        
        q = deque([])
        
        for i, row in enumerate(grid):
            for j, col in enumerate(row):
                if col == 2:
                    q.append((i,j))
        
        m, n = len(grid), len(grid[0])
        time = 0 
        directions = [(-1,0), (0,1), (1,0), (0,-1)]
        while q:
            size = len(q)
            flag = False
            while size>0:
                x, y = q.popleft()
                for cx, cy in directions:
                    nx = x + cx
                    ny = y + cy
                    if nx >=0 and nx < m and ny >=0 and ny < n and grid[nx][ny] == 1:
                        flag = True
                        grid[nx][ny] = 2
                        q.append((nx, ny))
                size-=1
            if flag:time+=1
        for i, row in enumerate(grid):
            for j, col in enumerate(row):
                if col == 1:
                    return -1
        return time