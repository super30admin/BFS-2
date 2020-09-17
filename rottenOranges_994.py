# // Time Complexity : O(n^2)
# // Space Complexity : O(n*m)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes, can you confirm the space complexity?

# // Your code here along with comments explaining your approach: 
 
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        #for level order traversal
        queue = []
        #keep a counter for fresh oranges to identify if there is a fresh orange that can't be reached from our graph, i.e., will never rot
        fresh = 0
        #keep track of minutes
        minutes = 0
        
        #Iterate through the grid to:
        #1. Keep count of fresh oranges
        #2. Adding rotten oranges to the queue
        # O(n*n)
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] ==1:
                    fresh += 1
                elif grid[i][j] == 2:
                    queue.append([i, j])
                
         #Maintain a directions array to easily access the 4-directional fresh oranges that may rot due to adjacent rotten oranges
        directions = [[1,0],[-1,0],[0,1],[0,-1]]
        
        # O(n + n*m)
        #level order traversal
        while queue:
            size = len(queue)
            
            if fresh == 0:
                return minutes
        
            minutes += 1
            
            # O(n) times
            for x in range(size):
                front = queue.pop(0)
                #check if an update is required in any direction listed in directions array
                # O(4), for all 4 directions
                for dirs in directions:
                    r = front[0] + dirs[0]
                    c = front[1] + dirs[1]
                    
                    if r>= 0 and r< len(grid) and c>= 0 and c< len(grid[0]) and grid[r][c]==1:
                        queue.append([r,c])
                        grid[r][c] = 2
                        fresh -= 1
        
        if fresh > 0:
            return -1
        
        return minutes