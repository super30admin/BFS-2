//BFS Approach

//Time Complexity:o(m*n)
//Space Complexity:O(m*n)
// Did the code run successfully on leet code: Yes

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        fresh = 0
        m = len(grid)
        n = len(grid[0])
        q = deque()
        time = 0
        for i in range(m):
            for j in range(n):

                if(grid[i][j] == 1):
                    fresh = fresh +1
                if(grid[i][j]==2):
                    q.append((i,j))
        if(fresh == 0):
            return 0
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]  
        
        while(q):
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    r = d[0] + curr[0]
                    c = d[1] + curr[1]
                    if(r>=0 and  r<m and c>=0 and c<n  and grid[r][c]==1):
                        grid[r][c]=2
                        fresh= fresh-1
                        q.append((r,c)) 
            time +=1
            
        if(fresh >0):
            return -1
        return time-1
