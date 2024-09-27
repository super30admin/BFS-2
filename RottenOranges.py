#Time Complexity:O(n2)
#space Complexity:O(1)
#LeetCode Submission:successful
#We use Bfs to find the Rotten oranges  and add it to queue and do bfs till there is a element in q
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        fresh=0
        m=len(grid)
        n=len(grid[0])
        q=[]
        for i in range(m):
            for j in range(n):
                if grid[i][j]==2:
                    q.append([i,j])
                if grid[i][j]==1:
                    fresh=fresh+1
        if fresh==0:
            return 0
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        count=0
        while(len(q) > 0):
            size=len(q)
            for i in range(size):
                rotten=q.pop(0)
                for d in dirs:
                    a=rotten[0]+d[0]
                    b=rotten[1]+d[1]
                    if a>=0 and a<m and b>=0 and b<n and grid[a][b]==1:
                        q.append([a,b])
                        grid[a][b]=2
                        fresh=fresh-1
            count=count+1
        if fresh !=0:
            return -1
        return count-1