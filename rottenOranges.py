#Leetcode(994) : Successful
#Time Com : O(mn)

class Solution:
    def orangesRotting(self, grid):
        #edge case
        #if no oranges in grid then 0
        if (len(grid)) == 0:
            return 0
        fresh = 0
        minutes = 0
        queue = []
        row = len(grid)
        col = len(grid[0])

        for i in range(row):
            for j in range(col):
                if grid[i][j] == 1:
                    #count the no. of fresh oranges
                    fresh +=1
                if grid[i][j] == 2:
                    #add the index of the rottens to queue
                    queue.append([i,j])
        #edge case
        #if no fresh oranges then return 0
        if fresh ==0:
            return 0

        #array to modify the rotten orange directions in 4directions
        dir = [[0,1],[1,0],[0,-1],[-1,0]]

        while len(queue) != 0:
            size = len(queue)
            #iterate over elements of queue
            for x in range(size):
                rotten = queue.pop(0)
                for d in dir:
                    #checking the neighbours of the rotten
                    i= rotten[0] + d[0]
                    j = rotten[1] + d[1]
                    #edge case
                    #if indices are within array bounds and the val in grid ==1 , i.e. fresh
                    if i >=0 and i <row and j >=0 and j <col and grid[i][j] ==1:
                        #make it rotten
                        grid[i][j] =2
                        #push its indices to queue
                        queue.append([i,j])
                        #decreease the count of fresh
                        fresh -=1
            #increase the minutes
            minutes +=1
        if fresh == 0 :
            #decrease minutes by 1 and return(as extra added for queue.length == 0)
            return minutes-1
        return -1

obj = Solution()
print(obj.orangesRotting([[2,1,1],[1,1,0],[0,1,1]]))
