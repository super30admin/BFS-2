# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from queue import Queue

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        # BFS
        q = Queue()
        q.put(root)
        
        while not q.empty():
            x_found, y_found = False, False
            size = q.qsize()
            
            for i in range(size):
                a = q.get()
                
                if a.left and a.right:
                    if a.left.val == x and a.right.val == y:
                        return False
                    if a.left.val == y and a.right.val == x:
                        return False
                
                if a.val == x:
                    x_found = True
                if a.val == y:
                    y_found = True
                
                if a.left:
                    q.put(a.left)
                if a.right:
                    q.put(a.right)
            
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
                        
        
        
#         DFS
        self.x_p = None
        self.y_p = None
        self.x_l = 0
        self.y_l = 0
        
        def findCousins(prev, root, level):
            
            if not root:
                return
            
            if x == root.val:
                self.x_p = prev
                self.x_l = level
            if y == root.val:
                self.y_p = prev
                self.y_l = level
    
            # For optimization. Break the recursion if both values found. 
            if not self.x_p or not self.y_p:
                findCousins(root, root.left, level + 1)
                findCousins(root, root.right, level + 1)
        
            return self.x_l == self.y_l and self.x_p != self.y_p
        
        return findCousins(None, root, 1)
        
