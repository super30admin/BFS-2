# Time Complexity : Add - O(m*n)
# Space Complexity :O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I have used BFS, where I have first calculated independent nodes, which are the rotten oranges itself
2. Then used BFS to push the neighbours in the queue, if they are fresh
3. Everytime I push a tomato toa queue I change its state by using 4 as a dummy integer, to avoid re-catering that
particular orange
'''

from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        if grid == [] or grid[0] == []:
            return -1
        queue = deque()
        
        rows = len(grid)
        cols = len(grid[0])
        fresh_count = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 2:
                    grid[i][j] = 4
                    queue.append((i,j))
                elif grid[i][j] == 1:
                    fresh_count += 1
                    
                    
        if fresh_count == 0:
            return 0
        
        if not queue:
            return -1
        
        minutes = -1
        dirs = [(0,-1),(0,1),(1,0),(-1,0)]
        while queue:
            
            minutes += 1
            size = len(queue)
            while size > 0:
                root = queue.popleft()
                for dir_ in dirs:
                    
                    new_x = root[0] + dir_[0]
                    new_y = root[1] + dir_[1]
                    if new_x >=0 and new_x < rows and new_y >=0 and new_y < cols:
                        if grid[new_x][new_y] == 1:
                            grid[new_x][new_y] = 4
                            fresh_count -= 1

                            queue.append((new_x, new_y))
                        
                size -= 1
                
        if fresh_count > 0:
            return -1
                
        return minutes
                        
                
                    
        