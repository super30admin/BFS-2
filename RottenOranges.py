from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        # To find minimumpath, we do BFS, DFS does not gaurantee a minimum distance. 
        # If you do a tree traversal and you want to reach a particular node in minimum distance, do BFS
        # Time Complexity - O(MN)
        # Space Complexity - O(MN)
        # Base case
        if grid == None:
            return 0
        
        nrows = len(grid)
        ncols = len(grid[0])
        
        # Direction to check when a rotten orange is found
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        
        
        freshOranges = 0 # Keeping count of fresh oranges as we need to check if all freshOranges are rotten
        queue = deque()
        
        # To add initial rotten oranges in the queue and to count number of fresh oranges initially
        for row in range(nrows):
            for col in range(ncols):
                if grid[row][col]==2:
                    queue.append([row,col])
                    
                elif grid[row][col] == 1:
                    freshOranges+=1
        
        # If no orange is fresh
        if freshOranges == 0:
            return 0
        
        # Initially they are starting from minute 0, so after first processing for time to become 0
        time = -1
        while (queue):
            qsize=len(queue)
            
            for i in range(qsize):
                row,col=queue.popleft()
                for di in dirs:
                    r = row + di[0]
                    c = col + di[1]
                    if (self.isValid(r,c,grid)):
                        grid[r][c]=2
                        freshOranges-=1
                        queue.append([r,c])
                    
            time+=1
            
        if freshOranges != 0:
            return -1
        
        return time
    
    def isValid(self,row,col,grid):
        
        nrows=len(grid)
        ncols=len(grid[0])
        
        if (row>=0 and row<nrows and col>=0 and col<ncols and grid[row][col] == 1):
            return True
        return False
        
                
                