#Approach



from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        columns = len(grid[0])
        fresh = 0
        time = 0
        queue = []

        for i in range(rows):
            for j in range(columns):
                if grid[i][j] == 2:
                    queue.append((i, j))
                elif grid[i][j] == 1:
                    fresh += 1
        if fresh == 0:
            return 0
        while queue:
            size = len(queue)

            for _ in range(size):
                curr = queue.pop(0)

                for direction in [1, -1]:  # ROWS
                    index = curr[0] + direction
                    if index >= 0 and index < rows:
                        if grid[index][curr[1]] == 1:
                            fresh -= 1
                            grid[index][curr[1]] = 2
                            queue.append((index, curr[1]))

                for direction in [1, -1]:  # ROWS
                    index = curr[1] + direction
                    if index >= 0 and index < columns:
                        if grid[curr[0]][index] == 1:
                            fresh -= 1
                            grid[curr[0]][index] = 2
                            queue.append((curr[0], index))
            time += 1

        if fresh > 0:
            return -1
        return time - 1
