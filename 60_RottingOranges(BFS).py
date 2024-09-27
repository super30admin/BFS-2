# Accepted on leetcode(994)
# Time - O(N) , space - O(N)
# We will consider BFS approach to solve this problem and start our tree/graph from rotten oranges.
# Then check all four directions and change the fresh to rotten and increase the minute count by 1.
# And also change the status of fresh orange (1) to rotten(2). At the end if fresh orages are left over retuen -1 else count-1.
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue = [] # initialize a queue
        m = len(grid) # height of grid
        n = len(grid[0]) # breadth of grid
        # edge case
        if m == 0: return 0
        fresh = 0 # count of fresh oranges.
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2: queue.append([i,j]) # add rotten orages to queue
                if grid[i][j] == 1: fresh += 1 # get the count of fresh orages.
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]  # directions array shows the direction in which we can move.
        count_minutes = 0
        while queue: # iterate over queue elements until empty
            size = len(queue) # get the queue size
            for k in range(size): # iterate over current queue elements
                rotten = queue.pop(0) # popped element from queue is rotten orange.
                for dir in dirs: # find neighbours of rotten oranges, if they are fresh convert them to rotten and reduce fresh count as well.
                    i = dir[0] + rotten[0]
                    j = dir[1] + rotten[1]
                    if i >= 0 and i < m and j >= 0 and j < n and grid[i][j] == 1:
                        queue.append([i,j])
                        grid[i][j] = 2
                        fresh -= 1
            count_minutes += 1 # increase minute count
        if fresh > 0: # if fresh oranges are leftover return - 1
            return -1
        elif coucount_minutesnt > 0:
            return count_minutes - 1
        else:
            return 0