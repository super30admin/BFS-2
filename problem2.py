#timecomplexity O(m*n)
#space complexityO(n*m)
# using bfs 
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #basecase
        if grid==None: return -1
        queue=[]
        #to keep the count of thefreash oranges
        fresh=0
        time=0 # time to get rotten
        #calculating the fresh org and adding rotten into the queue
        m=len(grid)
        n=len(grid[0])
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    fresh +=1
                elif grid[i][j]==2:
                    queue.append([i,j])
        
        if fresh==0: return 0
        _dir=[[0,1],[1,0],[-1,0],[0,-1]]
        #appying bfs on rotten organges and adding fresh if any in 4 direction into queue and making it rotten
        while queue:
            size=len(queue)
            
            for i in range(size):
                temp=queue.pop(0)
                for d in _dir:
                    x=temp[0]+d[0]
                    y=temp[1]+d[1]
                    if ((x>=0 and x<m) and (y>=0 and y<n) and (grid[x][y]==1)):
                        queue.append([x,y])
                        fresh-=1
                        grid[x][y]=2
            time+=1
        print(fresh)
        print(time)
        if fresh==0:
            return time-1
        else:
            return -1
 
            
            
        
        
        