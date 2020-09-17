# Time Complexity : O(nm)
# Space Complexity : O(nm) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#store all 2s row,col in queue and 1s in a counter. If found in any direction change it to 2 and decrement countern (Normal BFS)

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if len(grid) == 0 or grid == None:
            return 0
        res = 0
        queue = []
        fresh = 0
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == 2:
                    queue.append((i,j))
                elif grid[i][j] == 1:
                    fresh += 1
        
        if fresh == 0:
            return 0
        count = 0
        dirs = [[1,0], [-1,0], [0,1], [0,-1]]
        while queue:
            size = len(queue)
            if fresh == 0:
                return count
            count += 1
            for i in range(0, size):
                r,c = queue.pop(0)
                for d in dirs:
                    row = r + d[0]
                    col = c + d[1]
                    if 0 <= row < len(grid) and 0 <= col < len(grid[0]) and grid[row][col] == 1:
                            grid[row][col] = 2
                            fresh -= 1
                            queue.append((row,col))
                
        return -1
