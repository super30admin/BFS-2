// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid is None or len(grid)==0 or len(grid[0])==0:
            return 0
        #count for fresh oranges and starting point
        fresh=0
        minutes=0
        queue=[]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    fresh+=1
                elif grid[i][j]==2: #if orange is rotten add to queue
                    queue.append((i,j))
        print(queue,fresh)
        directions=[(-1,0),(0,1),(1,0),(0,-1)]
        while len(queue)!=0: #BFS
            size=len(queue)
            
            if fresh==0:
                return minutes
            minutes+=1
            print("Queue:",queue)
            for i in range(size): # for every node , check its neighbours for fresh orange
                poppedElement=queue.pop(0)
                
                for x in directions:
                    r=poppedElement[0]+x[0]
                    c=poppedElement[1]+x[1]
                    
                    if r>=0 and r<len(grid) and c>=0 and c<len(grid[0]) and grid[r][c]==1: # if fresh orange is present, add to queue
                        queue.append((r,c))
                        grid[r][c]=2
                        fresh-=1 #reduce fresh orange as it is rotten now

                        
            
            
        if fresh>0: 
            return -1
        return minutes #return final time
 