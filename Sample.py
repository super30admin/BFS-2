# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    Description: Find cousins in Binary Tree
    
    Time Complexicity: O(n), n -> number of elements in the tree
    Space Complexicity: O(h), h -> height/depth of the tree
    
    Approach:
    1. Use DFS to check if parents of x and y and depth 
    2. in recursive stack update the parent, and depth for each subtree
    3. match the criteria for same depth and different parents
    """
    
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        if root == None: return
        self.x_parent = TreeNode(); self.y_parent = TreeNode()
        self.x_depth = 0; self.y_depth = 0
        self.dfs(root, None, 0, x, y)
        return self.x_parent != self.y_parent and self.x_depth == self.y_depth
    
    def dfs(self, root, parent, depth, x, y):
        
        # Base case
        if root == None: return
        
        # logic
        if root.val == x:
            self.x_parent = parent
            self.x_depth = depth
            
        if root.val == y:
            self.y_parent = parent
            self.y_depth = depth
            
        self.dfs(root.left, root, depth + 1, x, y)
        self.dfs(root.right, root, depth + 1, x, y)
        
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    
    """
    Description: You are given a data structure of employee information.
    Return total importance value of given employee and all their subordinates

    Time Complexicity: O(n) {coming from Vertices and Edges of the graph: O(V+E)
    Space Complexicity: O(n) {for both DFS and BFS}

    Approach: Use a hashmap to identify pointers to each input index
    1. Using DFS -> find the employee subordinates and importance from the hashmap and add importances recursively
    2. Using BFS -> add a queue and add employee+subordinates importances to in a loop until no more subordinates are left
    """
    
    # Using DFS
    def getImportance(self, employees: List['Employee'], id: int) -> int:
     
        self.result = 0
        if employees == None or len(employees) == 0: return self.result
        self.emp_dict = {emp.id: emp for emp in employees}       
        self.dfs(id)
        return self.result
    
    def dfs(self, emp_id):
        # Base
        # Logic
        emp = self.emp_dict[emp_id]
        self.result += emp.importance
        for sub in emp.subordinates:
            self.dfs(sub)
    
    # Using BFS
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        from collections import deque
        result = 0
        if employees == None or len(employees) == 0: return result
        
        queue = deque()
        emp_dict = {emp.id: emp for emp in employees}   
        queue.append(id)
        while queue:
            emp_id = queue.popleft()
            emp = emp_dict[emp_id]
            result += emp.importance
            for sub in emp.subordinates:
                queue.append(sub)
                
        return result

class Solution:
       
    """    
    Description (Rotting Oranges): A grid representing empty(0), fresh orange(1), and rotten(2)    
    Return min number of minutes if it takes 1 min for rotten orange to rot adjacent oranges        

    Time Complexicity: O(m*n), where m and n represents dimensions of the grid    
    Space Complexicity: O(m*n)       

    Approach: Using BFS:
    1. make a queue starting from all the rotten oranges, if not return 0 and count fresh
    2. traverse through each queue member and go in all 4 directions to check for fresh orange
       - convert the fresh orange to rotten
       - append the queue by new rotten oranges
       - decrease count of fresh by 1 and increase time by 1 min
    3. check for edge case where the fresh oranges are still present, return -1 (as suggested)
    4. return time - 1 (decrese by 1 as it will account for next series)
    """
    
    def orangesRotting(self, grid: List[List[int]]) -> int:

        if grid == None or len(grid) == 0: return 0
        from collections import deque
        queue = deque(); time = 0; fresh = 0
        m = len(grid); n = len(grid[0])

        for cr in range(m):
            for cc in range(n):
                if grid[cr][cc] == 2:
                    queue.append((cr, cc))
                elif grid[cr][cc] == 1:
                    fresh += 1

        if fresh == 0: return 0
        dirs = [(0,1), (1,0), (0,-1), (-1,0)]
        while queue:
            length = len(queue)
            for i in range(length):
                r_pos, c_pos = queue.popleft() # tuple
                for d in dirs:
                    row = r_pos + d[0]; col = c_pos + d[1]
                    if row < m and col < n and row >= 0 and col >= 0 and grid[row][col] == 1:
                        grid[row][col] = 2
                        queue.append((row, col))
                        fresh -= 1
            time += 1
        if fresh != 0: return -1
        return time - 1            
