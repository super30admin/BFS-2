class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        fresh = 0
        q =[]
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append((i,j))
                if grid[i][j] == 1:
                    fresh += 1
        dirs = ((0,1),(1,0),(-1,0),(0,-1))
        count = 0
        while q != None:
            size = len(q)
            for k in range(size):
                rotten = q.pop(0)
                for d in dirs:
                    i = d[0] + rotten[0]
                    j = d[1] + rotten[1]
                    if i >= 0 and i < m and j >=0 and j <n and grid[i][j]==1:
                        q.append((i,j))
                        grid[i][j] = 2
                        fresh -= 1
            count += 1
        if fresh != 0:
            return -1
        if count > 0:
            return count-1
        else:
            return 0