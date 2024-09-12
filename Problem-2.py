class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        if grid is None or len(grid)==0:
            return 0

        q = collections.deque()
        fresh=0
        m = len(grid); n = len(grid[0])

        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    fresh+=1
                if grid[i][j]==2:
                    q.append([i,j])

        if fresh ==0:
            return 0

        time =0
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        while q:
            size = len(q)

            for _ in range(size):
                cur = q.popleft()
                for d in dirs:
                    r = d[0]+cur[0]
                    c = d[1] + cur[1]

                    if (r in range(m) and c in range(n) and grid[r][c]==1):
                        q.append([r,c])
                        fresh-=1
                        grid[r][c]=2

            time+=1

        if fresh >0:
            return -1
        return time-1
                    
