"""
Time complexity O(M x N)
Space complexity O(M x N)


"""
class Solution_orange:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid is None or len(grid)==0:
            return 
        fresh=0
        m=len(grid) 
        n=len(grid[0])
        
        q=[]
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    fresh+=1
                if grid[i][j]==2: #initially append rotten orange
                    q.append([i,j])
        
        if fresh==0:
            return 0
        time=0
        dirs=[[0,-1],[0,1],[1,0],[-1,0]]
        while q:
            
            size=len(q)
            for i in range(size):
                
                curr=q.pop(0)
                for d in dirs:
                    r=d[0]+curr[0]
                    c=d[1]+curr[1]
                    if r>=0 and r< m and c>=0 and c<n:
                        
                        if grid[r][c]==1:
                            q.append([r,c])
                            fresh-=1
                            grid[r][c]=2
            time+=1
            #increment time after processing each level
        if fresh>0:
            return -1
    
        return time-1
            
                    
                