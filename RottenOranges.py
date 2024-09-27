
---------------------------------- Rotten Oranges ---------------------------------------------
# Time Complexity : O(MXN) M is length of grid and N is the length of nodes
# Space Complexity : O(fresh) Max number of fresh oranges changing at each iteration.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can iterate through the grid and note the number of fresh oranges and append rotten oranges to the queue.
#Then we iterate through the queue and check the neighbors of the particular index. we have 2 conditions, if grid element is 1, we need to change to rotten.
#At each iteration we will count the minutes and reduce number of fresh oranges.Once we iterate through entire grid , if the number of fresh oranges becomes 0 then we return miutes.
 

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
    
        if not grid:
            return 0
        
        m = len(grid)
        n = len(grid[0])
        
        queue = deque()
        fresh = 0
        minutes = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh+=1
                elif grid[i][j] == 2:
                    queue.append((0 , i, j))
                
        while queue and fresh >0:
            prev_minutes , r, c = queue.popleft()
            
            for i, j in [(r+1, c), (r-1, c), (r, c+1), (r, c-1)]:
                if 0<=i<m and 0<=j<n and grid[i][j] ==1:
                    grid[i][j] = 2
                    fresh -=1
                    cur_minutes = prev_minutes+1
                    minutes = max(minutes, cur_minutes)
                    queue.append((cur_minutes, i,j))
        return minutes if fresh == 0 else -1
                    