

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
            
                              
        