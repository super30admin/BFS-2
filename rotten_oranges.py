#BFS approach
Time complexity - O(n)
space complexity - O(n/2)
Done on Leetcode: Yes
Problems faced: None
Description:
we start this by finding rotten tomatoes first and then try to traverse the four adjacent positions where there is fresh fruit and make it rotten. In this if all the tomatoes in the grid are rotten then we return True.

from collections import deque

class Solution(object):
    def __init__(self):
        self.d=deque([])
    def dirsarr(self,cell,grid):
        k=0
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        for j in dirs:
            row=cell[0]+j[0]
            col=cell[1]+j[1]
            if 0<=row<len(grid) and 0<=col<len(grid[0]) and grid[row][col]==1:
                grid[row][col]=2
                k=1
                print(cell,row,col)
                self.d.append((row,col))
        if k==1:
            return True
        return False
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        count=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    self.d.append((i,j))
        # print("dict is",self.d)
        while(len(self.d)!=0):
            m=0
            size=len(self.d)
            for i in range(size):
                cell1=self.d.popleft()
                if self.dirsarr(cell1,grid):
                    m=1
            if m==1:
                count=count+1
        # print(grid)
        t=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    t=1
        if t==1:
            return -1
        return count
                
        
        
                
                
                
            
                    