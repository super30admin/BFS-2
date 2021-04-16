"""
Approach 1 - BFS
TC - O(n)
SC - O(n/2) - O(n)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if (root == None):
            return False
        
        queue = []

        queue.append(root)
        x_found = False
        y_found = False
        
        while queue:
            size = len(queue)

            for i in range(size):
                current = queue.pop(0)
                if current.val == x:
                    x_found = True
                if current.val == y:
                    y_found = True
                    
                if (current.left and current.right):
                    if ((current.left.val == x and current.right.val == y) or (current.left.val == y and current.right.val == x)):
                        return False
                    
                if current.left:
                    queue.append(current.left)
                if current.right:
                    queue.append(current.right)
            
            if x_found and y_found:
                return True
            
            if x_found or y_found:
                return False
            
        return False

    
"""
Approach 2 - DFS
TC - O(n)
SC - O(h) 
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __dfs(self, root: TreeNode, parent: TreeNode, x: int, y: int, depth: int):
        # base
        if not root:
            return
        
        # logic
        if (x == root.val):
            self.x_parent = parent
            self.x_depth = depth
            
        if (y == root.val):
            self.y_parent = parent
            self.y_depth = depth
    
        self.__dfs(root.left, root, x, y, depth + 1)
        self.__dfs(root.right, root, x, y, depth + 1)
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        
        self.__dfs(root, None, x, y, 0)
        
        return self.x_parent != self.y_parent and self.x_depth == self.y_depth