from collections import deque

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # Cases that I missed: 1. No fresh oranges, No rotten oranges
        
        # Idea: Consider rotten oranges as the multiple root nodes of the tree. Traversing the grid using BFS, will help us find the neighbours that are fresh and can be rotten.
        
        # Time Complexity: O(M*N)
        # Space Complexity: O(M*N)
        directions = [(0,1),(1,0),(-1,0),(0,-1)]
        queue = deque()
        nrows = len(grid)
        ncols = len(grid[0])
        fresh_oranges = 0
        for i in range(nrows):
            for j in range(ncols):
                if grid[i][j] == 2:
                    queue.append((i,j))
                else:
                    if grid[i][j] == 1:
                        fresh_oranges += 1
        time_counter = 0
        if fresh_oranges == 0:
            return 0
        print(fresh_oranges)
        while len(queue) > 0:
            time_counter += 1
            qsize = len(queue)
            for i in range(qsize):
                popped_element = queue.popleft()
                row,col = popped_element[0],popped_element[1]
                for direction in directions:
                    curr_row = row + direction[0]
                    curr_col = col + direction[1]
                    if curr_row < 0 or curr_row >= nrows or curr_col < 0 or curr_col >= ncols or grid[curr_row][curr_col] != 1 or grid[curr_row][curr_col] == 0:
                        continue
                    fresh_oranges -= 1
                    grid[curr_row][curr_col] = 2
                    queue.append((curr_row,curr_col))
        if fresh_oranges > 0:
            return -1
        return time_counter-1
        
        
