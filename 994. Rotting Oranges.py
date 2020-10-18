"""
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
"""

class Solution:
"""
    Run TIme Complexity: O(N*M)
    Space Complexity: O(N)
    
    
    Traverse through entire grid and count number of fresh fruits.
    Add all rotten fruits to queue.
    Now perform BFS and spoil all fresh fruits that are in surrounding of the rotten fruits.
"""
    def orangesRotting(self, grid: List[List[int]]) -> int:
        minutes = 0
        count = 0
        queue = deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(grid[i][j]) == 1: count += 1
                if(grid[i][j] == 2):
                    queue.append((i, j))
                        
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        while queue:
            for i in range(len(queue)):
                i , j = queue.popleft()
                for dir in directions:
                    new_i = i +dir[0]
                    new_j = j + dir[1]
                    if ((0 <= new_i < len(grid)) and (0<= new_j < len(grid[0])) and grid[new_i][new_j] == 1):
                        grid[new_i][new_j] = 2
                        queue.append((new_i, new_j))
                        count -= 1
            minutes += 1   
        return max(0, minutes-1) if (count == 0) else -1