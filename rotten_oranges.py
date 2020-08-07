from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        dire=[(0,1),(0,-1),(1,0),(-1,0)]
        if grid==None or len(grid)==0:
            return -1
        queue=deque()
        fresh=0
        Rows=len(grid)
        Cols=len(grid[0])
        for r in range(Rows):
            for c in range(Cols):
                if grid[r][c]==2:
                    queue.append((r,c))
                elif grid[r][c]==1:
                    fresh+=1
        queue.append((-1,-1))
        minutes=-1
        while queue:
            row,col=queue.popleft()
            if row==-1:
                minutes+=1
                if queue:
                    queue.append((-1,-1))
            else:
                for d in dire:
                    neighbor_row, neighbor_col = row + d[0], col + d[1]
                    if Rows > neighbor_row >= 0 and Cols > neighbor_col >= 0:
                        if grid[neighbor_row][neighbor_col] == 1:
                            grid[neighbor_row][neighbor_col] = 2
                            fresh -= 1
                            queue.append((neighbor_row, neighbor_col))
        return minutes if fresh == 0 else -1
#Time-Complexity: O(N)
#space-complexity:O(N)
                
        
        