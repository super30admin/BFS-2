"""
Problem:
https://leetcode.com/problems/rotting-oranges/

Approach: BFS


1. maintain the count of freshOranges, time and a queue  
2. Traverse the grid to find the no of freshOranges, if a cell contain a rooten orange, put the co-ordinates of that cell int eh queue
3. Start popping elemnts from the stack, if the neighbours of the popped cell has fresh oranges, then rot those ornages and put it in the que


"""

# Time Complexity : O(m*n) , m is rows, n is columns
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) ==0:
            return 0
        
        que = deque()
        freshCount = 0
        time =0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    freshCount+=1
                if grid[i][j]==2:
                    que.append((i,j))
        
        #return 0 if no rotten oranges in the grid
        if freshCount ==0:
            return 0
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        while(que):
            size = len(que)
            for i in range(size):
                cur = que.popleft()
                for dir in dirs:
                    r = cur[0]+dir[0]
                    c = cur[1]+dir[1]
                    if(r>=0 and r<len(grid) and c>=0 and c<len(grid[0]) and grid[r][c]==1):
                        grid[r][c]=2
                        freshCount-=1
                        que.append((r,c))
            time+=1
            
        if freshCount!=0:
            return -1
        
        return time-1