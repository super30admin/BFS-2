
#All TC passed on leetcode

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #Here we follow BFS approach. We add all rotten oranges into queue, and also keep count of fresh oranges. 
        #We itearte in loop until queue is not empty. In each iteration we  check the poped element's 
        #4 neighbors if any neighbor is 1 then we change it to 2(rotten) and add it to queue. We increment 
        #time for each queue size processed. If at the beginning fresh count is 0 and queue is empty the we return 0.
        #Time complexity - O(m*n) where m-rows and n-cols
        #Space complexity - O(m*n) 
        m = len(grid)
        n = len(grid[0])
        directions = [[-1,0], [1,0], [0,-1], [0,1]]
        fresh = 0
        time = 0
        queue = collections.deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:
                    queue.append((i,j))
                if grid[i][j]==1:
                    fresh+=1
        
        if not queue and fresh==0:
            return time

        while queue:
            for i in range(len(queue)):
                r, c = queue.popleft()

                for dr, dc in directions:
                    nr = dr + r
                    nc = dc + c
                    if nr>=0 and nc>=0 and nr<m and nc<n and grid[nr][nc]==1:
                        fresh-=1
                        grid[nr][nc]=2
                        queue.append((nr,nc))
            time+=1

        return time-1 if fresh==0 else -1 
                    



        

        