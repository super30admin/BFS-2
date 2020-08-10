# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque()
        frsh = 0
        t = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    frsh += 1
                elif grid[i][j] == 2:
                    q.append((i,j))
        if frsh == 0:
            return t
        nei = [[-1,0], [0,-1], [1,0], [0,1]]
        
        while len(q) != 0:
            size = len(q)
            
            for i in range(size):
                curr = q.popleft()
                for j in nei:
                    r = curr[0] + j[0]
                    c = curr[1] + j[1]
                    
                    if r >= 0 and r < len(grid) and c >= 0 and c < len(grid[0]) and grid[r][c] == 1:
                        grid[r][c] = 2
                        frsh -= 1
                        q.append((r,c))            
            t += 1
            
        if frsh == 0:
            return t-1
        else:
            return -1