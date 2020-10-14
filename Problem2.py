# Time Complexity: O(N)
# Space Complexity: O(N)
# Passed Leetcode
from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        visited = set()
        queue = deque()
        x_vals = [-1, 1, 0, 0]
        y_vals = [0, 0, -1, 1]
        rotten_list = []
        for i in range(len(grid)):
            
            for j in range(len(grid[0])):
                
                if grid[i][j] == 2:
                    rotten_list.append((i, j))
                    visited.add((i, j))
        queue.append(rotten_list)
        
        
        time = -1
        while len(queue) > 0:
            
            nodes = queue.popleft()
            time += 1
            node_list = []
            for node in nodes:
                
                i, j = node
                
                for k in range(len(x_vals)):
                    x, y = i + x_vals[k], j + y_vals[k]
                    
                    if x >= 0 and y >= 0 and x < len(grid) and y < len(grid[0]) and (x, y) not in visited and grid[x][y] == 1:
                        
                        grid[x][y] = 2
                        visited.add((x, y))
                        node_list.append((x, y))
            if len(node_list) > 0:
                queue.append(node_list)
        for i in range(len(grid)):
            
            for j in range(len(grid[0])):
                
                if grid[i][j] == 1:
                    return -1
        return time
        