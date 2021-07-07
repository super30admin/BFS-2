class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q=[]
        row=len(grid)
        col=len(grid[0])
        if not grid:
            return 0
        fresh=0
        dir={(0,-1),(-1,0),(1,0),(0,1)}
        for i in range(row):
            for j in range(col):
                if(grid[i][j]==2):
                    q.append((i,j))
                if(grid[i][j]==1):
                    fresh+=1
        time=0            
        while q:
            size=len(q)
            for i in range(size):
                rotten=q.pop(0)
                for d in dir:
                    r=rotten[0]+d[0]
                    c=rotten[1]+d[1]
                    if((r>=0) and (r<row) and (c>=0) and (c<col) and (grid[r][c]==1)):
                            grid[r][c]=2
                            q.append((r,c))
                            fresh-=1
    
            time+=1
        if(fresh>0):
            return -1
        elif(time>0):
            return time-1
        else:
            return 0
            
