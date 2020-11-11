#Time Complexity : O(n) where n is number of elements in the grid
#Space Complexity :  O(n) where n is number of elements in the grid

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: First we iterate through the grid and find the number of fresh oranges and push the coordinates of the rotten oranges in a queue. Now keeping track of time, we perform BFS, trying all four directions to see if any of the oranges around the rotten one are fresh, if they are then we reduce the variable of fresh oranges and conver the fresh orange to rotten and add in the queue. We keep track of level, as the rotting of all oranges is considered as one minute.


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = 0
        rows, cols = len(grid), len(grid[0])
        q = deque([])

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    fresh += 1
                elif grid[r][c] == 2:
                    q.append((r,c))

        if fresh == 0:
            return 0

        time = -1
        directions = [(0,1), (1,0), (-1, 0), (0,-1)]

        while q:
            for _ in range(len(q)):
                r, c = q.popleft()
                for x,y in directions:
                    newX, newY = r+x, c+y
                    if 0 <= newX and newX < rows and 0 <= newY and newY < cols and grid[newX][newY] == 1:
                        fresh -= 1
                        grid[newX][newY] = 2
                        q.append((newX, newY))
            time += 1

        return max(0, time) if fresh == 0 else -1
