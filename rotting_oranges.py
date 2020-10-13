# O(N) TIME AND O(N) SPACE WHERE N IS SIZE OF GRID

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        visited = [[False for j in range(len(grid[i]))] for i in range(len(grid))]
        queue = []
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2:
                    queue.append([i,j])
        return self.calculateRottenTime(queue,grid,visited)
    
    def calculateRottenTime(self,queue,grid,visited):
        minutes = -1
        while len(queue):
            minutes += 1
            for _ in range(len(queue)):
                i,j = queue.pop(0)
                if visited[i][j]:
                    continue
                visited[i][j] = True
                grid[i][j] = 2
                self.appendFreshNeigbours(i,j,grid,visited,queue)
        
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    return -1
        
        return minutes if minutes != -1 else 0

    def appendFreshNeigbours(self,i,j,grid,visited,queue):
        for row,col in [[i,j+1],[i+1,j],[i,j-1],[i-1,j]]:
            if row >= 0 and row < len(grid) and col >= 0 and col < len(grid[0]) and grid[row][col]==1 and  not visited[row][col]:
                queue.append([row,col])
                grid[row][col]=2
                

