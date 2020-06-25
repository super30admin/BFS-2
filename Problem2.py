# Time Complexity : O(m x n) time
# Space Complexity : O(m x n) space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution :
    def orangesRotting(self,grid):
        time = 0 
        fresh = 0 
        q = []
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1 
                if grid[i][j] == 2:
                    q.append([i,j])
        if fresh == 0:
            return 0 # there is no point of doing anything, as nothing will get rotten. 
        
        while q: 
            size = len(q)
            for _ in range(size):
                curr = q.pop(0)
                dirs = [[1,0],[-1,0],[0,1],[0,-1]]
                for dir in dirs:
                    r = dir[0] + curr[0]
                    c = dir[1] + curr[1]
                    
                    if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == 1:
                        grid[r][c] = 2 # Fresh orange becomes rotten 
                        q.append([r,c]) # add the new rotten
                        fresh -= 1 
            time += 1 # This add one extra count for last rotten cell, but that cell wont have anything to rotten. so we nee to decrement by 1 before returning.
        
        if fresh > 0:
            return -1 # was not able to rot each fresh orange.
        
        if time == 0: # if there is no rotten orange in the entire grid the we have not invested any time 
            return 0 
        return time - 1
             
        
if __name__ == "__main__":
    grid = [[2,1,1],[1,1,0],[0,1,1]]
    s = Solution()
    res = s.orangesRotting(grid)
    print(res)
    