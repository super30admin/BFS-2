# BFS Approach
# Time - O(N)
# Space - O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        result = []
        
        if root == None:
            return False
        
        queue = []
        queue.append(root)
        
        x_found = False
        y_found = False
        
        
        while queue != []:
            size = len(queue)
            
            for i in range(size):
                
                current = queue.pop(0)
                
                if current.val == x:
                    x_found = True
                    
                if current.val == y:
                    y_found = True
                    
                if current.left != None and current.right != None:
                    
                    if current.left.val == x and current.right.val == y:
                        # then they are siblings
                        return False
                    
                    if current.left.val == y and current.right.val == x:
                        return False
                    
                if current.left != None:
                    queue.append(current.left)
                    
                if current.right != None:
                    queue.append(current.right)
                    
            if x_found and y_found:
                return True
            
            if x_found or y_found:
                return False
    
## DFS Approach
# Time - O(N)
# Space - O(H) - call stack under the hood


class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:

        self.x_parent = None
        self.y_parent = None
        self.x_depth = 0
        self.y_depth = 0

        self.dfs(root, None, 0, x, y)
        return self.x_parent != self.y_parent and self.x_depth == self.y_depth


    def dfs(root, parent, level, x, y):

        # base case
        if root == None:
            return 


        # logic

        if root.val == x:
            self.x_parent = parent
            self.x_depth = depth

        if root.val == y:
            self.y_parent = parent
            self.y_depth = depth

        # if not found we continue recursing on left then right

        self.dfs(root.left, root, depth + 1, x, y)
        
        # Once we hit None node on left, st.pop() happens

        self.dfs(root.right, root, depth + 1, x, y)
