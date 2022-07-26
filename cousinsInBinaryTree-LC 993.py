# Time Complexity = O(n)
# Space Complexity = O(h), recursive stack in DFS


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# DFS Solution
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None or x == y:
            return False
        
        # Declaring the depth and parent variables
        self.x_depth = 0
        self.y_depth = 0
        
        self.x_parent = None
        self.y_parent = None
        
        self.dfs(root, 0, None, x, y)
        
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent
    
    
    
    def dfs(self, root: TreeNode, lvl, parent: TreeNode, x, y):
        if root == None:
            return
        
        # Capturing the level and parent if x is found
        if root.val == x:
            self.x_depth = lvl
            self.x_parent = parent
        
        # Capturing the level and parent if y is found
        if root.val == y:
            self.y_depth = lvl
            self.y_parent = parent
            
        self.dfs(root.left, lvl + 1, root, x, y)
        self.dfs(root.right, lvl + 1, root, x, y)
'''        
# BFS Solution
# Time Complexity = O(n)
# Space Complexity = O(n)


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None or x == y:
            return False
        
        
        q = []
        q.append(root)
        
        while q:
            x_found = False
            y_found = False
            
            size = len(q)
            
            for i in range (size):
                curr = q.pop(0)
                
                if curr.val == x:
                    x_found = True
                
                if curr.val == y:
                    y_found = True
                
                # If a root has 2 valid children, check if they both are equal to x and y, if yes, they aren't cousins coz of the same parent
                if curr.left != None and curr.right != None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                    
                if curr.left != None:
                    q.append(curr.left)
                    
                if curr.right != None:
                    q.append(curr.right)
                    
            
            if x_found == True and y_found == True:
                return True
            
            if x_found == True or y_found == True:
                return False
            
        
        return True
            
'''       
        