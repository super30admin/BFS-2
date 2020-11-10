class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        def getNeighbors(r, c, ROW, COLUMN):
        # ((up), (left), (down), (right))
            for nr, nc in ((r-1, c), (r, c-1), (r+1, c), (r, c+1)):
                if 0 <= nr < ROW and 0 <= nc < COLUMN:
                # use yield to make this function a generator (one time iterable)
                    yield nr, nc

        # Initialize queue
        q = collections.deque()
        d = 0
        ROW = len(grid)
        COLUMN = len(grid[0])
        
        # Populate queue with verices -> 2
        for r, row in enumerate(grid):
            for c, val in enumerate(row):
                if val == 2:
                    q.append((r,c,0))
                    
        # BFS
        while q:
            r,c,d = q.popleft()
            for nr, nc in getNeighbors(r,c,ROW,COLUMN):
                if grid[nr][nc] == 1:
                    grid[nr][nc] = 2
                    q.append((nr,nc,d+1))
        
        if any(1 in row for row in grid):
            return -1
        
        return d