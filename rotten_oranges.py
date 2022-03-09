#time- m*n, space -m*n
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        q=deque()
        fresh=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    fresh+=1
                if grid[i][j]==2:
                    q.append((i,j))
        if fresh==0:
            return 0
        level=0
        print(q)
        while q:
            size=len(q)
            
            for i in range(size):
                curr=q.popleft()
                for j in dirs:
                    x=curr[0]+j[0]
                    y=curr[1]+j[1]
                   
                    if x>=0 and x<len(grid) and y>=0 and y<len(grid[0]) and grid[x][y]==1:
                        fresh-=1
                        grid[x][y]=2
                        q.append((x,y))
            
            level+=1
            print(q,level)
        if fresh==0:
            return level-1
        return -1