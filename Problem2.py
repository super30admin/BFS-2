# Time Complexity : O(MxN) (Where M is no of row and N is no of column)
# Space Complexity : O(MxN) (Where M is no of row and N is no of column)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Use BFS to spread in 4 direction. Consider every rotten fruit as root and add it in the queue.
# - Keep count of fresh fruit when adding fruits in the queue. Run loop until fresh fruit becomes 0 and elemnts are available in queue. After every length of queue is processed increase level by 1.
# - For every rotten fruit from queue, check all valid neighbour and update it accordingly. If we update the neighbout to be rotten add it at the end of the queue. 

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
#       Covering corner cases
        if not grid:
            return 0
        
#       Find length of row and column
        rowlen = len(grid)
        collen = len(grid[0])
#       Updated row and column that covers allowed 4 direction 
        drow = [-1, 1 , 0, 0]
        dcol = [0, 0, 1 , -1]
#       Initialize queue, level and frsh variable
        queue = []
        fresh = 0
        level = 0
#       Iterate throught every cell of the matrix
        for i in range(rowlen):
            for j in range(collen):
#               Count the fresh fruit
                if grid[i][j] == 1:
                    fresh += 1
#               Add cordinates of rotten fruit in the queue.
                elif grid [i][j] == 2:
                    queue.append((i, j))
                    
#       If we don't have any fresh fruit we don't need any iteration to make it rotten. So return 0.
        if fresh == 0:
            return 0
        
#       Run the loop until queue is empty and we have 0 fresh fruit
        while queue and fresh > 0:
#           Count the current element in the queue and run for loop on taht length, because we are adding more element in the queue dynamically but we want to keep track of level.
            lq = len(queue)
            for i in range(lq):
#               Pop the first elemnt of the queue to process it
                current = queue.pop(0)
                (row, col) = current
#               Check all valid direction
                for j in range(4):
#                   Update row and column
                    nrow = row + drow[j]
                    ncol = col + dcol[j]
#                   Check if fruit cordinates are not out of bound and fruit is fresh
                    if 0 <= nrow and nrow < rowlen and 0 <= ncol and ncol < collen and grid[nrow][ncol] == 1:
#                       Decrease fresh fruit count
                        fresh -= 1
#                       Make the fruit rotten and add it to the queue
                        grid[nrow][ncol] = 2
                        queue.append((nrow, ncol))
                    else:
                        continue
#           Incraese level of BFS
            level += 1
       
#       If we didn't rotten all the fresh fruit return -1 otherwise return BFS level nedded to do it.
        if fresh == 0:
            return level 
        else:
            return -1
                    
                
