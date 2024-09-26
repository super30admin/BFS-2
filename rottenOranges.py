"""BFS approach"""

#Accepted on Leetcode
#Time complexity - O(N) as we are visiting every node
#Space complexity - O(N) for the queue 


from collections import deque
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        fresh = 0
        count = -1
        q = deque()
        m = len(grid)
        n = len(grid[0])
        #Edge case
        if m == 0:
            return 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append((i,j))
                if grid[i][j] == 1:
                    fresh += 1
        if fresh == 0:#After traversing, if the fresh oranges are zero, then return minutes 0
            return 0
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        while len(q) > 0:#corrected here
            size = len(q)
            for k in range(size):
                rotten = q.popleft()
                for d in dirs:
                    i = d[0] + rotten[0]
                    j = d[1] + rotten[1]
                    if 0 <= i < m and 0 <= j < n:#check boundaries conditions for neighbours
                        if grid[i][j] == 1:
                            q.append((i,j))
                            grid[i][j] = 2
                            fresh -= 1
            count += 1
        if fresh > 0:
            return -1
        elif fresh == 0 and count > 0:
            return count
        else:
            return 0