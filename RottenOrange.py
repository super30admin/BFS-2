#Time Complexity : O(N)  where N is number of elements in grid
#Space Complexity : O(B) maximum breadth
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        Queue = []
        time  = 0
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh +=1
                if grid[i][j] == 2:
                    Queue.append([i,j])
        if fresh == 0:
            return fresh 
        while(len(Queue)>0):
            size = len(Queue)
            for i in range(size):
                curr = Queue.pop(0)
                for s in dirs:
                    r = s[0] + curr[0]
                    c = s[1] + curr[1]
                    if r >= 0 and r < m and c>=0 and c<n and grid[r][c] ==  1:
                        grid[r][c] =2
                        Queue.append([r,c])
                        fresh-=1
            time+=1
            
        if fresh ==0 :
            return (time-1)
        return -1