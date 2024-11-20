"""
Time:O(n*m) where m and n are dimensions of grid
Space: O(1)
Leet: Accepted
Problems: None
"""

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        curr_level = []
        fresh = 0
        minutes = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    curr_level.append((i,j)) #first level of bfs is populated with rotten
                elif grid[i][j] == 1:
                    fresh += 1 #count fresh

        while len(curr_level)>0:
            new_level = []
            for position in curr_level:
                i = position[0]
                j = position[1]
                for x, y in [[0, 1], [1, 0], [-1, 0], [0, -1]]: #find neighbors
                    nx = i + x
                    ny = j + y
                    if 0 <= nx < len(grid) and 0 <= ny < len(grid[0]) and grid[nx][ny] == 1:
                        grid[nx][ny] = 2 #rot it if fresh
                        fresh -= 1 #decrement
                        new_level.append((nx, ny)) #append newly rotten orange to next level
            curr_level = new_level #switch levels
            if len(curr_level) > 0:
                minutes += 1

        if fresh == 0:
            return minutes
        return -1
