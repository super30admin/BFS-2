# Leetcode 994. Rotting Oranges

# Time Complexity :  O(m X n) where m X n is the size of the grid

# Space Complexity : O(m X n) where m X n is the size of the grid

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: First traverse the array to count the fresh oranges and append rotten ones to Q. Increment 
# timer when a new level is processed. For every node in the level, check if the neighbours are fresh. 
# IF true then change them to rotten, append to the queue and decrement the fresh count. Once Q is empty,
# check if any fresh oranges remain then return -1 else return the time it took.

# Your code here along with comments explaining your approach

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = 0
        q = deque()
        # Travesing the grid and appending rotten oranges to queue, counting fresh oranges
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] ==2:
                    q.append((i,j))
                    
        dirs= {(-1, 0), (0, 1), (1, 0), (0, -1)}
        
        time = -1
        # While q is not empty
        while q:
            # Incrementing timer after every level in the Q
            time += 1
            # iterating over every item in the level
            for _ in range(len(q)):
                i,j = q.popleft()
            
                # Checking if the neighbors are fresh and changing them to rotten and adding to Q
                for direc in dirs:
                    r = i + direc[0]
                    c = j + direc[1]
                    
                    if len(grid) > r >= 0 and len(grid[0]) > c >= 0 and grid[r][c] == 1:
                        fresh -= 1
                        grid[r][c] = 2
                        q.append((r,c))        
        # Return time if no fresh ones remain else return -1     
        if fresh == 0:
            return max(0,time)
        else:
            return -1