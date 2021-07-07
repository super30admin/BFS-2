# Time Complexity : O(m*n)
# Space Complexity : O(m*n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Logic

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        level = 0
        queue = []
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    queue.insert(0,(i,j,level))
                    grid[i][j] = 0
        

        while queue:
            row,col,level = queue.pop()
            
            for i,j in [row -1,col],[row+1,col],[row,col-1],[row,col+1]:
                if 0 <= i < len(grid) and 0<=j<len(grid[0]) and grid[i][j] == 1:
                    queue.insert(0,(i,j,level+1))
                    grid[i][j] = 0

        if any(1 in row for row in grid):
            return -1
        else:
            return level
