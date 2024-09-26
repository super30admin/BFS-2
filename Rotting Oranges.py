# // Time Complexity : O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 

#Logic
# We used BFS for this
# 1. Find the node which are rotton
# 2. put those into queue also keep track of fresh oranges
# 3. Use Directions array to look for fresh orange near rotton 
# 4. if found fresh convert to rotton decrese the fresh count

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None and len(grid)==0: return 0
        
        row = len(grid)
        col = len(grid[0])
        res=0
        fresh=0
        q = deque()
        
        for i in range(row):
            for j in range(col):
                if grid[i][j]==2:
                    q.append((i,j))
                if grid[i][j]==1:
                    fresh+=1
        
        if fresh==0: return 0
        directions = [(1,0),(0,-1),(-1,0),(0,1)]

        while q:
            size = len(q)
            for i in range(size):
                cur = q.popleft()
                for di in directions:
                    r = cur[0]+di[0]
                    c = cur[1]+di[1]

                    if r>=0 and c>=0 and r< row and c< col and grid[r][c]==1:
                        grid[r][c]=2
                        fresh-=1
                        print("fresh ",fresh)
                        q.append((r,c))
                        
            res+=1
                
        
        if fresh>0:
            return -1
        return res-1
            
       