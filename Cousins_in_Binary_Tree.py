from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #BFS
    def isCousins_B(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        
        q = deque()

        q.append(root)
        
        while q:
            size = len(q)
            x_found = False
            y_found = False

            for i in range(size):
                node = q.popleft()
                if node.val == x:
                    x_found = True
                
                if node.val == y:
                    y_found = True                       
                
                #Sibling check
                if node.left and node.right:
                    if (node.left.val == x or node.right.val == x) and (node.left.val == y or node.right.val==y):
                        
                        return False
                        
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)            
         
            if x_found and y_found:
                return True    
            if x_found or y_found:
                return False                            
        return False
                
    #DFS
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        self.x_parent = None
        self.y_parent = None
        self.x_lvl = 0
        self.y_lvl = 0
        
        self.dfs(root,None,x,y,0)
    
        return self.x_parent != self.y_parent and self.x_lvl == self.y_lvl
      
    def dfs(self,root,parent,x,y,lvl):
        #Base
        if not root:
            return
        
        #Logic
        if root.val == x:
            self.x_parent = parent
            self.x_lvl = lvl
            
        if root.val == y:
            self.y_parent = parent        
            self.y_lvl = lvl
        
        self.dfs(root.left, root, x, y, lvl+1)
        self.dfs(root.right, root, x, y, lvl+1)
