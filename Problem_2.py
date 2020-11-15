"""
Time Complexity : O(m*n) as we need to traverse the matrix to find index of rotten oranges
Space Complexity : O(m*n)- as length of queue increases rapidly and can have max of all oranges at once
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Here, I am doing a BFS solution. For this, we need to traverse the whole matrix once to put into the queue the
index of oranges that are already rotten.Simultaneously, we will take a variable that keeps the track of fresh 
oranges. secondly, we would start traversing the queue. Once we take out an index, we traverse all 
4 directions, and check if the orange is fressh, we make it rotten, put its value inside the queue and
decrease the fresh count by 1. After we have traversed the size of the queue, ie one level, we increment the time
by 1. At last, we check if fresh is ). If not, that means we cannot rot all the oranges and hence return -1.
Otherwise, we return the time variable.
"""
from collections import deque


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        q = deque()
        fresh = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append((i, j))
                if grid[i][j] == 1:
                    fresh += 1
        if fresh == 0:
            return 0
        dirs = [(0, -1), (-1, 0), (0, 1), (1, 0)]
        time = 0
        while q:
            size = len(q)
            for s in range(size):
                curr = q.popleft()
                r = curr[0]
                c = curr[1]
                for d in dirs:
                    i = r+d[0]
                    j = c+d[1]
                    if i >= 0 and i < m and j >= 0 and j < n and grid[i][j] == 1:
                        grid[i][j] = 2
                        q.append((i, j))
                        fresh -= 1
            time += 1
        if fresh > 0:
            return -1
        return time-1
