# APPROACH  
# Time Complexity : O(mn), m: number of rows of given grid, n: number of columns of given grid 
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Take count of fresh orange and store position of all rotten orange in queue (st we can process them together)
# 2. Do BFS traversal. each time, check it's 4 neighbors. if fresh, change it to rotten state and store it's coordinates in queue, also after processing a level, inc time
# 3. At end check if fresh count is 0, then only return time else return -1 (as fresh oranges still exist)

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        if grid is None:
            return -1
        
        fresh_count, time, queue, dirs = 0, 0, deque(), [[0, -1], [0, 1], [-1, 0], [1, 0]]
        
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 1:
                    fresh_count += 1
                    
                if grid[row][col] == 2:
                    queue.append((row, col))
        
        if fresh_count == 0:
            return 0
        
        while len(queue) > 0:
            size = len(queue)
            while size > 0:
                pos = queue.popleft()
                for nei in dirs:
                    if pos[0] + nei[0] >= 0 and pos[0] + nei[0] < len(grid) and pos[1] + nei[1] >= 0 and pos[1] + nei[1] < len(grid[0]) and grid[pos[0] + nei[0]][pos[1] + nei[1]] == 1:
                        grid[pos[0] + nei[0]][pos[1] + nei[1]] = 2
                        queue.append((pos[0] + nei[0], pos[1] + nei[1]))
                        fresh_count -= 1
                size -= 1
                        
            time += 1
            
        if fresh_count != 0:
            return -1
        else:
            return time - 1
            
            
