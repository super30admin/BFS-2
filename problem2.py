class Solution:
    
    def runDFSOnRotten(self, grid, cost_grid, i_pos, j_pos):
        queue = [(0, i_pos, j_pos)]
        
        while len(queue) != 0:
            size = len(queue)
            for i in range(size):
                orange_element = queue.pop(0)
                cost_grid[orange_element[1]][orange_element[2]] = orange_element[0]
                
                if orange_element[1] + 1 < len(grid) and \
                    orange_element[2] < len(grid[0]) and \
                    cost_grid[orange_element[1] + 1][orange_element[2]] is not None and \
                     (cost_grid[orange_element[1] + 1][orange_element[2]] == -1 or \
                     orange_element[0] + 1 < cost_grid[orange_element[1] + 1][orange_element[2]]):
                    queue.append((orange_element[0] + 1, orange_element[1] + 1,  orange_element[2]))

                if orange_element[1] < len(grid) and \
                    orange_element[2] + 1 < len(grid[0]) and \
                    cost_grid[orange_element[1]][orange_element[2] + 1] is not None and \
                        (cost_grid[orange_element[1]][orange_element[2] + 1] == -1 or \
                        orange_element[0] + 1 < cost_grid[orange_element[1]][orange_element[2] + 1]):
                    queue.append((orange_element[0] + 1, orange_element[1],  orange_element[2] + 1))
                    
                if 0 <= orange_element[1] - 1 and \
                    0 <= orange_element[2] and \
                    cost_grid[orange_element[1] - 1][orange_element[2]] is not None and \
                        (cost_grid[orange_element[1] - 1][orange_element[2]] == -1 or \
                        orange_element[0] + 1 < cost_grid[orange_element[1] - 1][orange_element[2]]):   
                    queue.append((orange_element[0] + 1, orange_element[1] - 1,  orange_element[2]))
                
                if 0 <= orange_element[1] and \
                    0 <= orange_element[2] - 1 and \
                    cost_grid[orange_element[1]][orange_element[2] - 1] is not None and \
                        (cost_grid[ orange_element[1]][orange_element[2] - 1] == -1 or \
                        orange_element[0] + 1 < cost_grid[ orange_element[1]][orange_element[2] - 1]): 
                    queue.append((orange_element[0] + 1, orange_element[1],  orange_element[2] - 1))
                
        return
    
    
    def orangesRotting(self, grid: List[List[int]]) -> int:
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        cost_grid = [[None] * len(grid[i]) for i in range(len(grid))]
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2:
                    cost_grid[i][j] = 0
                if grid[i][j] == 1:
                    cost_grid[i][j] = -1
        
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2:
                    self.runDFSOnRotten(grid, cost_grid, i, j)
        
        max_val = 0
        for i in range(len(cost_grid)):
            for j in range(len(cost_grid[i])):
                if cost_grid is not None and cost_grid[i][j] == -1:
                     return -1
                else:
                     if cost_grid[i][j] is not None and max_val < cost_grid[i][j]:
                        max_val = cost_grid[i][j]
                     
                     
        return max_val
            