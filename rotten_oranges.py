"""
// Time Complexity : O(m*n) 
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Probably missing some edge cases
// Your code here along with comments explaining your approach
Algorithm explanation
Method1 - BFS on the rotten oranges(value 2)
- Iterate over the fresh count for values equal to 1
- Add the values 2 to the queue for running bfs on
- While queue is not empty
    - Iterate over the given size of elements(level wise)
        - pop the x,y of rotten orange, check the validity for next direction frmo 
        all 4 directions ( value is not 2 and 0)
            - Add the direction to queue if valid
            - Update grid[x][y] = 2
            - Decrement fresh by 1 
    -Increment time
- If fresh is 0 return time-1 else -1
"""

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        def is_valid_direction(grid,i,j,m,n):
            if i < 0 or i >=m or j < 0 or j >=n or grid[i][j]==2 or grid[i][j] == 0:
                return False
            return True
        
        #BFS Method
        if not grid or not grid[0]:
            return 0
        q = []
        m = len(grid)
        n = len(grid[0])
        #Get the rotten oranges
        fresh = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append((i,j))
                elif grid[i][j] == 1:
                    fresh+=1
        
        if fresh == 0:
            return 0
        
        time = 0
        
        while q:
            #new = []
            size = len(q)
            for i in range(size):
                i,j = q.pop(0)
                directions = [(-1,0),(0,-1),(1,0),(0,1)]
                for x,y in directions:
                    if is_valid_direction(grid,x+i,y+j,m,n):
                        q.append((x+i,y+j))
                        grid[x+i][y+j] = 2
                        fresh-=1
            time+=1
        
        
        return time-1 if fresh == 0 else -1