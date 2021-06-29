# Time Complexity: O(n)
# Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Maintain parent of x and y globally along with levels
    def __init__(self):
        self.x_parent = TreeNode(-1)
        self.y_parent = TreeNode(-1)
        self.x_level = 0
        self.y_level = 0
        
    def dfs(self, root, x, y, parent, level):
        # Base
        if root is None:
            return 
        
        # Logic
        # Update the level when we find x and the parent also 
        if root.val == x:
            self.x_level = level
            self.x_parent = parent
            
        # Update the level when we find y and the parent also 
        if root.val == y:
            self.y_level = level
            self.y_parent = parent
        
        # Recursively call dfs on children with parent as root and level is incremented
        self.dfs(root.left, x, y, root, level + 1)
        self.dfs(root.right, x, y, root, level + 1)
        
        
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        self.dfs(root, x, y, None, 0)
        
        # Check if they are of same level but should not have same parent
        return self.x_parent != self.y_parent and self.x_level == self.y_level









# BFS
# Time Complexity: O(n)
# Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# from collections import deque
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        # Null condition check
        if root is None:
            return
        # Declare a queue
        # Append root
        q = deque()
        q.append(root)
        
        # Two flags to check if x and y are found
        x_found = False
        y_found = False
        
        # While q exists, get size and iterate through each level
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                
                # Check if the current value is x or y and change flag respectively
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                
                # If the children exist, check that they are not x and y
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.right.val == x and curr.left.val == y:
                        return False
                
                # If children exist, append to the queue
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            
            # Return true if both are found as expected
            if x_found and y_found:
                return True
            # If both are not found, return false as the other may be somewhere down the tree and is not a cousin
            if x_found or y_found:
                return False
        
        return False