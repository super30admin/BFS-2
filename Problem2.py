"""
// Time Complexity : o(m*n), 
// Space Complexity : o(min(m,n)), m->rows,n->cols
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
--> BFS - add all rotten oranges to queue
--> keep count of fresh oranges
-->change neighbouring fresh to rotten 
--> check if any fresh oranges remaining

// Your code here along with comments explaining your approach
"""

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque()
        
        r = len(grid)
        c = len(grid[0])
        fresh = 0
        q = deque()
        
        dirs = [[1,0],[-1,0],[0,1],[0,-1]] # directions list
        
        for i in range(r):
            for j in range(c):
                if grid[i][j] == 2: #adding cells with initial rotten oranges
                    q.append((i,j))
                elif grid[i][j] == 1: #keeping count of all fresh oranges initially
                    fresh += 1
                    
        if fresh == 0: #if no rotten oranges
            return 0
                    
        mins = -1 # from -1 since, at mins = 0 first level will be processed     
                    
        while q:
            size = len(q) # keeping check of size, to keep track of minutes at each level
            
            for s in range(size):
                cur = q.popleft()

                for d in dirs: #checking all neighbours for fresh oranges
                    row = cur[0] + d[0]
                    col = cur[1] + d[1]

                    if row >= 0 and row < r and col >= 0 and col < c and grid[row][col] == 1:
                        grid[row][col] = 2 #changing to rotten 
                        q.append((row,col))
                        fresh -= 1 # decrementing fresh count
            mins += 1
            
        if fresh != 0: #if there are still fresh oranges remaining, return -1
            return -1
        
        return mins