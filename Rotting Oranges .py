
class Solution:
    # BFS 
    # time : O(M*N)
    # space : 
    # NOTE: pay attenetion to boundary conditions 
    
    def rottingOranges(self, grid):
        if grid == []:
            return 0
        
        q = []
        count = 0
        fresh = 0
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    q.append([i, j])
                if grid[i][j] == 1:
                    fresh += 1
        if not q:
            if not fresh:
                return 0
            return -1
        
        while q != []:
            size = len(q)
            for i in range(size):
                root = q.pop(0)
                for dir in dirs: 
                    r = root[0] + dir[0]
                    c = root[1] + dir [1]
                    if 0 <= r < len(grid) and  0 <= c < len(grid[0]):
                        if grid[r][c] == 1:
                            grid[r][c] += 1
                            fresh -= 1
                            q.append([r, c])      
            count += 1
            
        if fresh != 0:
            return -1

        return count-1               # count -1

obj = Solution()
print(obj.rottingOranges(grid=[[2,1,1],[1,1,0],[0,1,1]]))


    
            


