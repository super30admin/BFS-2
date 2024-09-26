# Time Complexity: O(mn) where m and n are length of row, column
# Space Complexity: O(mn)

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        def isValid(x, y, grid):
            nrows = len(grid)
            ncols = len(grid[0])
            
            if x >= 0 and x < nrows and y >= 0 and y < ncols and grid[x][y] == 1:
                return True
            return False
        
        if not grid:
            return 0
        
        rows = len(grid)
        cols = len(grid[0])
        
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        freshOranges = 0
        
        queue = deque()
        
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 2:
                    queue.append((i,j))
                elif grid[i][j] == 1:
                    freshOranges += 1
        if freshOranges == 0:
            return 0
        
        time = -1
        while queue:
            queueSize = len(queue)
            for i in range(queueSize):
                r, c = queue.popleft()
                for d in dirs:
                    x = r + d[0]
                    y = c + d[1]
                    if isValid(x, y, grid):
                        grid[x][y] = 2
                        freshOranges -= 1
                        queue.append((x,y))
            time += 1
        return time if freshOranges == 0 else -1
                    
