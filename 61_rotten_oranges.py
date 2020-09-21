# S30 Big N Problem #61 {Medium}

# LC - 994. 
# Rotting Oranges

# Time Complexity : O(n*m) n=rows , m=columns
# Space Complexity : O(n*m) n=rows , m=columns
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach 
# when a rotten orange is found, store the adjacent fresh oranges in stack 
# at every iteration, get the number of rotten oranges at given instances, and fill the stack. 
# when the fresh oranges are over, return the iterations i,e. mins. 
# this problem uses BFS traversal of graph 


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        queue=[]
        
        fresh=0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                
                if grid[i][j]==1:
                    fresh+=1
                if grid[i][j]==2:
                    queue.append((i,j))
        
        mins=0
        
        dirs=((0,-1),(-1,0),(1,0),(0,1))
        while queue:
            
            if fresh==0:
                break
            
            mins+=1
            
            length=len(queue)
            
            for i in range(length):
                x,y=queue.pop(0)
                for dx,dy in dirs:
                    
                    if x+dx>=0 and x+dx<len(grid) and y+dy>=0 and y+dy<len(grid[0]):  
                        if grid[x+dx][y+dy]==1:
                            queue.append((x+dx,y+dy))
                            grid[x+dx][y+dy]=2
                            fresh-=1
                            
        
        if fresh==0:
            return mins
        else:
            return -1
                
                            
            
        