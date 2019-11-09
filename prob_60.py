#leetcode 994
#have a dir array and accordingly access all the elements and process them with simultaneously decrementing the fresh oranges count and incrementing minutes.

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        visited=[[False for _ in range(len(grid[0]))] for _ in range(len(grid))]
        minutes=-1
        fresh=0
        q=[]

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j]==2:
                    q.append((i,j))
                    visited[i][j]=True
                elif grid[i][j]==1:
                    fresh=fresh+1

        if fresh==0: return 0

        dir=[(0,1),(1,0),(-1,0),(0,-1)]
        while q:
            size=len(q)
            for i in range(size):
                q_con=q[i]
                r,c=q_con
                for (x,y) in dir:
                    x_new,y_new=r+x,c+y
                    if ( (0<=x_new<len(grid)) and (0<=y_new<len(grid[0])) ):
                        if not visited[x_new][y_new] and grid[x_new][y_new]==1:
                            q.append((x_new,y_new))
                            grid[x_new][y_new]=2
                            visited[x_new][y_new]=True
                            fresh -= 1
            minutes=minutes+1 #Once the level is done we are increasing the minutes by 1
            q=q[size:]
        if (fresh==0):
            return minutes
        else:
            -1