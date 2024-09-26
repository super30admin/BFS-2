
# 994. Rotting Oranges

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # Initializing the Rotten and Fresh stores
        q = collections.deque()
        fresh = set()
        
        # Iterating over the matrix to store the (i,j) values of rotten and fresh fruits
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    fresh.add((i,j))
                elif grid[i][j] ==2:
                    q.append((i,j))
                    
        minutes = 0
        # Can be rotten in these 4 directions
        dirs = [(0, -1), (-1, 0), (0, 1), (1, 0)]

        # While we have rotten oranges - BFS
        while q:
            if not fresh:
                break
            
            for i in range(len(q)):
                # Rotten x and y
                x,y = q.popleft()
                
                # Checking for each direction
                for dx,dy in dirs:
                    nx = x + dx
                    ny = y + dy
                    
                    # If we have a fresh orange in the direction we are checking, remove from fresh and add it in rotten
                    if (nx,ny) in fresh:
                        fresh.remove((nx,ny))
                        q.append((nx,ny))
            
            # At each level we increment the timer
            minutes+=1
        
        # If we have any fresh oranges left over, we return -1
        if not fresh:
            return minutes
        else:
            return -1
                
# Time Complexity: O(N*M)
# Space Complexity: O(N)
# Accepted on Leetcode: Yes.