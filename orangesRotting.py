#Time Complexity:O(n), n being the total number of elements in the matrix
#Space Complexity: O(n)
#Ran successfully on Leetcode:Yes

#BFS Solution:
#Algorithm:
# 1. Calculate the length of rows and cols of matrix. 
# 2. Iterate through it and count fresh oranges, and if they are rotten , add then m to queue created. 
# 3. Set time ==0
# 4. Now pop pout of queue and store in curr variable, check its neighbour if there are fresh oranges, and convert them to rotten by assigning 2 and add their location to queue.
# 5. At the end if the fresh array is zero, we return time, else -1



class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh=0
        if not grid or len(grid)==0:
            return fresh
        q=[]
        m=len(grid)
        n=len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    fresh+=1
                if grid[i][j]==2:
                    q.append((i,j))
        print(fresh)
        time=0
        if fresh==0:
             return 0
        while(q):
            size=len(q)
            for _ in range(size):
                curr=q.pop(0)
                for i,j in [(1,0),(0,1),(-1,0),(0,-1)]:
                    r=curr[0]+i
                    c=curr[1]+j
                    if  0<=r<m and 0<=c<n and grid[r][c]==1:
                        grid[r][c]=2
                        q.append((r,c))
                        fresh-=1
            time+=1
        if fresh==0:
            return time-1
        else:
            return -1
                

        
