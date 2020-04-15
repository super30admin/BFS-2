"""
// Time Complexity : O(m*n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Probably missing some edge cases
// Your code here along with comments explaining your approach
Algorithm explanation
Method1 - BFS on the rotten oranges(value 2)
- Iterate over the fresh count for values equal to 1
- Add the values 2 to the queue for running bfs on
- While queue is not empty and fresh is not 0
    - pop the x,y of rotten orange, check the validity for next direction frmo 
    all 4 directions ( value is not 2 and 0)
        - Add the direction to queue if valid
        - Update grid[x][y] = 2
        - Decrement fresh by 1 
    -Increment time
- If fresh is 0 return time else -1

Future scope
- I think I may be missing something to updating the queue by means of new
"""

class Solution(object):
    def orangesRotting(self, grid):
        def is_valid_direction(grid,i,j,m,n):
            if i < 0 or i >=m or j < 0 or j >=n or grid[i][j]==2 or grid[i][j] == 0:
                return False
            return True
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        #BFS Method
        if not grid:
            return -1
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
        
        
        if not q:
            return -1
        
        count = float("-inf")
        #i,j = q[0][0],q[0][1]
        time = 0
        while q and fresh:
            new = []
            i,j = q.pop(0)
            directions = [(-1,0),(0,-1),(1,0),(0,1)]
            for x,y in directions:
                if is_valid_direction(grid,x+i,y+j,m,n):
                    new.append((x+i,y+j))
                    grid[x+i][y+j] = 2
                    fresh-=1
            time+=1
            q = new
        
        return time if fresh == 0 else -1