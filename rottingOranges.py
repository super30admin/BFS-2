# Time Complexity : O(n * m)
# Space Complexity : O(n * m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue = deque([])
        fresh=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1: fresh+=1
                if grid[i][j]==2: queue.append((i,j))

        mins=0
        dirs=((0,-1),(-1,0),(1,0),(0,1))
        while queue:
            if fresh==0: break
            mins+=1
            length=len(queue)
            for i in range(length):
                x,y=queue.popleft()
                for r_x,r_y in dirs:
                    r = x + r_x
                    c = y + r_y
                    if r>=0 and r<len(grid) and c>=0 and c<len(grid[0]) and grid[r][c] == 1:  
                        queue.append((r,c))
                        grid[r][c]=2
                        fresh-=1

        if fresh==0: return mins
        else: return -1