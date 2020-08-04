#Time complexity: O(m*n)
#Space complexity: O(m*n)
#Works on leetcode: yes
#Approach: Here we count all fresh oranges and add position of rotten oranges in a queue. We then pop items through the queue
# and check if any of it's adjacent orange is fresh(and make it rotten and reduce fresh count) and also add the new rotten
#orange's position to the queue, all the while keeping track of the time(or iteration in while loop). 
import collections as cl
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        queue = cl.deque([])
        count = 0
        time=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    count +=1
                if grid[i][j]==2:
                    queue.append((i,j))
        while queue:
            for _ in range(len(queue)):
                i,j = queue.popleft()
                for x,y in [(i+1,j),(i-1,j),(i,j-1),(i,j+1)]:
                    if 0<=x<len(grid) and 0<=y<len(grid[0]) and grid[x][y]==1:
                        grid[x][y]=2
                        count-=1
                        queue.append((x,y))
            time+=1
            
        return max(0,time-1) if count==0 else -1