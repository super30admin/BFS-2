class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if(grid == None or len(grid) == None or len(grid[0]) == None):
            return -1
        
        fresh = 0 
        queue = deque()
        n = len(grid)
        m = len(grid[0])
        minutes = 0
        
        for i in range(0, n):
            for j in range(0, m):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    queue.append([i, j])
        
        directions = [[1,0], [-1,0], [0,1], [0,-1]]
        
        if(fresh == 0):
            return minutes
        
        while(queue):
            size = len(queue)            
            for _ in range(0, size):
                top = queue.popleft()
                for dirs in directions:
                    r = top[0] + dirs[0]
                    c = top[1] + dirs[1]
                    
                    if(r >=0 and r < n and c >=0 and c < m and grid[r][c] == 1):
                        grid[r][c] = 2
                        queue.append([r, c])
                        fresh -= 1            
            minutes += 1
        
        if(fresh > 0):
            return -1
        else:
            return minutes - 1
