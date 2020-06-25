
"""

    Name : Shahreen Shahjahan Psyche
    Time : O(M * N)
    Space : O(N)

    This code passed all the test cases in Leetcode

"""
from typing import List

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        if not grid:
            return -1
        
        
        from collections import deque
        
        q = deque()
        
        # O(m*n)
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    q.append((i, j))
        
        
        time = 0
        direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        while q: # O(4*m*n)
            size = len(q)
            k = 0
            while(k<size): 
                curr = q.popleft()
                for i in direction: # O(4)
                    pos_i = curr[0] + i[0]
                    pos_j = curr[1] + i[1]
                    if pos_i < len(grid) and pos_i > -1 and pos_j < len(grid[0]) and pos_j > -1:
                        #print(pos_i, pos_j)
                        if grid[pos_i][pos_j] == 1:
                            grid[pos_i][pos_j] = 2
                            q.append((pos_i, pos_j))
                k += 1
            if q:
                time += 1
        # O(m*n)
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    return -1
                
        return time
                    
                    
                    
                    
                    
                
                
                
            
            
            
            
            
            
            
            
        
        
        
        
        
        
        