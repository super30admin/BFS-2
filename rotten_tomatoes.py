'''

https://leetcode.com/problems/rotting-oranges
Did it run on leetcode: Yes
Did you face any problem: how not to make rotten tomato not rotten again

It is a BFS solution
Time complexity: 0(N)
Space Complexity: 0(N)

'''


class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        visited = [ [False for _ in range(len(grid[0]))] for _ in range(len(grid)) ]
        rottenTomatoes = []
        minutesSpend = -1
        numOfFreshTomato = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j]==2:
                    rottenTomatoes.append((i,j))
                    visited[i][j] = True
                elif grid[i][j]==1:
                    numOfFreshTomato +=1
        
        if numOfFreshTomato==0:
            return 0
        
        dirs = [(0,1),(0,-1),(-1,0),(1,0)]
        while rottenTomatoes:
            size=len(rottenTomatoes)
            for i in range(size):
                rottenTomato = rottenTomatoes[i]
                r,c=rottenTomato
                for (x,y) in dirs:
                    newX,newY = r+x,c+y
                    if ( (0<=newX<len(grid)) and (0<=newY<len(grid[0])) ):
                        if not visited[newX][newY] and grid[newX][newY]==1:
                            rottenTomatoes.append((newX,newY))
                            grid[newX][newY]=2
                            visited[newX][newY]=True
                            numOfFreshTomato -= 1
            
            minutesSpend +=1
            print("grid at:",minutesSpend)
            print(grid)
            rottenTomatoes = rottenTomatoes[size:]
        
        return minutesSpend if numOfFreshTomato==0 else -1
        
        
        
        
            
            
        
        
                
        