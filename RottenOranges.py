"""
The approach here is to first find all the rotten oranges initially then maintian there indexes in a
list. and also count the number of fresh oranges.now we also make a adjacent matrix list which we will use for traversing and marking the oranges
rotten at each step. now we traverse through the initial rotten oranges list which we made. and at each 
index of the rotten oranges we check if there are any fresh oranges near by if so we mark them as rotten
and decrease the count by 1 and also append the index of new rotten oranges to a new list and change the
old rotten oranges list to the new one.

Leetcode running
Space complexity O(N)
Time complexity - O(N)
"""

def orangesRotting(self, grid):
        oranges, fresh, minutes = [], 0, 0
        adjacent_oranges = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    oranges.append((i, j))
                elif grid[i][j] == 1:
                    fresh += 1
        
        while oranges:
            new_oranges = []
            for i, j in oranges:
                for x, y in adjacent_oranges:
                    nx = i + x
                    ny = j + y
                    if 0 <= nx < len(grid) and 0 <= ny < len(grid[0]) and grid[nx][ny] == 1:
                        grid[nx][ny] = 2
                        fresh -= 1
                        new_oranges.append((nx, ny))
            oranges = new_oranges
            if oranges:
                minutes += 1

        return minutes if not fresh else -1