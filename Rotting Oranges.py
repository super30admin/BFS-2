# TC: O(N)
# SC: O(N)
#Yes, it ran on leetcode withour problems

import collections
class Solution(object):
    def orangesRotting(self, grid):
        if len(grid)==1 and len(grid[0])==1 and grid[0][0]==0:
            return 0
        queue = collections.deque()
        visited = set()
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    queue.append((i,j))
        #print(queue)
        count = 0
        dirs = [(1,0),(-1,0),(0,1),(0,-1)]
        
        
        while queue:
            print(queue)
            for i in range(len(queue)):
                
                curr = queue.popleft()
                x,y = curr
                visited.add((x,y))
                for d in dirs:
                    new_x = x+d[0]
                    new_y = y+d[1]            
                    if 0<=new_x<len(grid) and 0<=new_y<len(grid[0]) and grid[new_x][new_y]==1 and (new_x,new_y) not in visited:
                        queue.append((new_x,new_y))
                        grid[new_x][new_y] = 2
                        visited.add((new_x,new_y))
            count += 1
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    return -1
        return count-1
            