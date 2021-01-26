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
