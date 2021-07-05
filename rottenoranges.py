# Runs on Leetcode

# BFS
  # Runtime - O(n)
  # Memory - O(n)
  

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return
        queue = []
        fresh_oranges = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    queue.append([i,j])
                if grid[i][j] == 1:
                    fresh_oranges += 1
                    
        if not queue and grid == [[0]]:
            return 0
        directions = [[0,1],[0,-1],[1,0],[-1,0]] 
        count = 0
        
        while queue:
            for j in range(len(queue)):
                present_orange = queue.pop(0)
                if grid[present_orange[0]][present_orange[1]]!=0:
                    for i in directions:
                        a = present_orange[0] + i[0]
                        b = present_orange[1] + i[1]
                        if 0 <= a < len(grid) and 0<= b <len(grid[0]) and grid[a][b] == 1:
                            queue.append([a,b])
                            grid[a][b] = 2
                            fresh_oranges -= 1
            count += 1
            
        if fresh_oranges != 0:
            return -1
        return count-1