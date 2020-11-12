class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        row = len(grid)
        col = len(grid[0])
        count = 0
        queue = deque()
        
        for i in range(row):
            for j in range(col):
                if grid[i][j]==1:
                    count+=1
                elif grid[i][j] == 2:
                    queue.append((i,j))
        time = 0
        if count == 0:
            return 0
        while queue:
            for i in range(len(queue)):
                i,j = queue.popleft()
                direction = [[1,0],[0,1],[-1,0],[0,-1]]
                for dir in direction:
                    if 0<=i+dir[0]<len(grid) and 0<=dir[1]+j<len(grid[0]) and grid[i+dir[0]][dir[1]+j]==1:
                        queue.append((i+dir[0],dir[1]+j))
                        grid[i+dir[0]][dir[1]+j] = 4
                        count-=1
            time+=1
        return time-1 if count==0 else -1
            
Time: O(M*N)
Space: O(M*N)
  