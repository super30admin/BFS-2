# Using breadth first search
# Time complexity - O(m*n)
# Space complexity - O(m*n) length of queue
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        fresh = 0
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]     # down, up, right, left
        q = deque()
        
        # iterate through the grid to find the beginning locations.
        for i in range(n):
            for j in range(m):
                if grid[i][j]==2:
                    q.append((i, j))    # append the beginning locations.
                elif grid[i][j]==1:
                    fresh += 1          # increment the count of fresh oranges.
                    
        if fresh==0: return 0           # if there are no fresh oranges, time is 0.
        
        time = 0
        while q:
            time += 1
            for _ in range(len(q)):
                # current location
                pos = q.popleft()
                r, c = pos[0], pos[1]

                # check neighborhood grid locations
                for d in directions:
                    if 0<=r+d[0]<n and 0<=c+d[1]<m and grid[r+d[0]][c+d[1]]==1:
                        fresh -= 1
                        grid[r+d[0]][c+d[1]]=2
                        q.append((r+d[0], c+d[1]))  # check for neighbors for the new location
            
        
    
        return time-1 if fresh==0 else -1
        