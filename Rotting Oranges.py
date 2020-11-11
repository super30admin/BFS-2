# Time Complexity:- O(n*n)
# Space Complexity:- O(n*n)
# Approach: Traverse the entire matrix and keep a track of all the live oranges and the dead oranges. Add the dead oranges to a queue, we need to do a bfs from the dead oranges.
# Start a bfs from the dead oranges and check how many live oranges are being infected by the dead oranges. At the end of the bfs check if the number of live oranges infected are equal to the number of live oranges we counted at first.
from collections import deque
import collections
class Solution:
    def orangesRotting(self, grid):
        # can traverse only in this four directions
        derse_array=[[1,0],[-1,0],[0,1],[0,-1]]
        # queue needed to bfs containing the dead oranges
        q=collections.deque([])
        # number of live oranges we have seen so far
        live=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==2:
                    # append dead oranges to the queue
                    q.append((i,j))
                elif grid[i][j]==1:
                    # increment counter of live oranges
                    live+=1
        q.append(-1)
        res=0
        seen=set()
        while(q):
            rotten=q.popleft()
            if rotten==-1:
                if not q:
                    break
                q.append(-1)
                # a minute has gone by one round of infection is complete
                res+=1
                continue
            for i,j in derse_array:
                tempi=i+rotten[0]
                tempj=j+rotten[1]
                if 0<=tempi<len(grid) and 0<=tempj<len(grid[0]) and grid[tempi][tempj]==1 and (tempi,tempj) not in seen:
                    # a live orange is being infected decrement counter of live oranges
                    live-=1
                    q.append((tempi,tempj))
                    seen.add((tempi,tempj))
        # if no more live oranges return minutes gone by else if we still have live oranges return -1
        return res if live==0 else -1
                    
                    