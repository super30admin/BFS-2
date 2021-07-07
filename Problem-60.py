

#leet code -Rotting Oranges - https://leetcode.com/problems/rotting-oranges/
# Time complexity -O(M*N)
#space complexity =O(M*N)
# Approach - DFS approach 




class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        visited=[[False for _ in range(len(grid[0]))] for _ in range(len(grid))]
        minutes=-1
        fresh=0
        rotten=[]
        
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j]==2:
                    rotten.append((i,j))
                    visited[i][j]=True
                elif grid[i][j]==1:
                    fresh=fresh+1
                
        if fresh==0: return 0
        
        dir=[(0,1),(1,0),(-1,0),(0,-1)]
        while rotten:
            size=len(rotten)
            for i in range(size):
                rotten1=rotten[i]
                r,c=rotten1
                for (x,y) in dir:
                    x_new,y_new=r+x,c+y
                    if ( (0<=x_new<len(grid)) and (0<=y_new<len(grid[0])) ):
                        if not visited[x_new][y_new] and grid[x_new][y_new]==1:
                            rotten.append((x_new,y_new))
                            grid[x_new][y_new]=2
                            visited[x_new][y_new]=True
                            fresh -= 1
            minutes=minutes+1 # whenever we are done with the level then we are incresing the minutes by 1
            rotten=rotten[size:]
        return minutes if fresh==0 else -1 # when fresh is 0 we return minutes 
            
                              
            
# BFS Solution - without valid matrix            
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        queue = [] 
        m = len(grid) 
        n = len(grid[0])
        # edge case
        if m == 0: return 0
        fresh = 0 # count of fresh oranges.
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2: queue.append([i,j]) 
                if grid[i][j] == 1: fresh += 1 
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]  
        count_minutes = 0
        while queue: 
            size = len(queue) 
            for k in range(size): 
                rotten = queue.pop(0) 
                for dir in dirs:
                    i = dir[0] + rotten[0]
                    j = dir[1] + rotten[1]
                    if i >= 0 and i < m and j >= 0 and j < n and grid[i][j] == 1:
                        queue.append([i,j])
                        grid[i][j] = 2
                        fresh -= 1
            count_minutes += 1 
        if fresh > 0: 
            return -1
        elif count_minutes > 0:
            return count_minutes - 1
        else:
            return 0
        
