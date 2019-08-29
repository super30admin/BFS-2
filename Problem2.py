# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        depth = 0

        def validindexer(r, c):
            for vr, vc in ((r - 1, c), (r, c - 1), (r, c + 1), (r + 1, c)):
                if 0 <= vr < rows and 0 <= vc < cols:
                    yield vr, vc

        queue = []
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    queue.append((r, c, 0))

        while queue:
            r, c, depth = queue.pop(0)
            for vr, vc in validindexer(r, c):
                if grid[vr][vc] == 1:
                    grid[vr][vc] = 2
                    queue.append((vr, vc, depth + 1))

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    return -1
        return depth