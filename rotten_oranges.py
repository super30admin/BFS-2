# TC & SC - 0(m*n)

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if grid == None :
            return 0
        q = []
        fresh = 0
        m , n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    fresh+=1
                elif grid[i][j]==2:
                    q.append([i,j])
        
        time = 0
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        
        if fresh ==0:
            return 0
        while (len(q)!=0) :
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                for dir in dirs:
                    r = dir[0]+curr[0]
                    c = dir[1]+curr[1]
                    if (r>=0 and c>=0 and r < m and c < n and grid[r][c]==1):
                        grid[r][c]=2
                        fresh -=1
                        q.append([r,c])
            time+=1
            
        if fresh ==0:
            return time-1
        return -1
