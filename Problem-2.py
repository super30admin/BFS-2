"""
## Problem2 (https://leetcode.com/problems/rotting-oranges/)
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.


"""


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) == 0:
            return
        m = len(grid)
        n = len(grid[0])
        q = collections.deque()
        fresh = 0
        level = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    q.append([i, j])
        if fresh == 0:
            return 0
        directions = [[0, 1], [-1, 0], [1, 0], [0, -1]]
        time = 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for dir in directions:
                    r = dir[0] + curr[0]
                    c = dir[1] + curr[1]
                    if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == 1:
                        grid[r][c] = 2
                        q.append([r, c])
                        fresh -= 1
            time += 1
        if fresh > 0: return -1
        return time - 1




