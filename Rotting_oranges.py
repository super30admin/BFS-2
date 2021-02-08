  
// Time Complexity : O(R*C)
// Space Complexity : O(R*C)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: using BFS and queue, traversing through graph and notiing fresh oranges and storing rotten oranges on a queue.




class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        rows = len(grid)
        
        if rows == 0:
            return -1
        
        cols = len(grid[0])
        fresh = 0
        
        q = deque()
        
        for r in range(0,rows):
            for c in range(0,cols):
                
                if grid[r][c] == 2:
                    q.append((r,c))
                elif grid [r][c] == 1:
                    fresh += 1
                    
        minutes = 0
                    
        while q and fresh > 0:
            
            minutes += 1
            
            for i in range(0, len(q)):
                
                x,y = q.popleft()

                for dx, dy in [(1,0), (-1,0), (0,1), (0,-1)]:
                    xx, yy = x + dx, y + dy

                    if xx >=0 and xx < len(grid) and yy >= 0 and yy < len(grid[0]) and grid[xx][yy] == 1:
                        fresh -= 1
                        grid[xx][yy] = 2
                        q.append((xx,yy))
                        
        if fresh > 0:
            return -1
        else:
            return minutes
