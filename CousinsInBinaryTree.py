# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#TC = O(n)
#SC = O(h)?
from  queue import Queue
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None:
            return False
        x_found = False
        y_found = False
        q = Queue()
        result = []
        q.put(root)
        while not q.empty():
            size = q.qsize()
            if curr.val == x:
                x_found = True
            if curr.val == y:
                y_found = True
            for i in range(size):
                curr = q.get()
                if(curr.right != None and curr.left != None):
                    if(curr.right == x and curr.left == y):
                        return False
                    if(curr.right == y and curr.left == x):
                        return False
                if curr.left != None:
                    q.put(curr.left)
                if curr.right != None:
                    q.put(curr.right)
            if x_found == True and y_found == True:
                return True
            if x_found == True or y_found == True:
                return True
            
            return False
        





# class Solution:
#     def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
#         if root == None:
#             return False
        
#         self.result = []
#         self.x_parent = None
#         self.y_parent = None
#         self.x_level = 0
#         self.y_level = 0
#         self.dfs(root,x,y,None, 0)
#         return self.x_parent != self.y_parent and self.x_level == self.y_level

#     def dfs(self, root:Optional[TreeNode] , x : int , y :int, parent: Optional[TreeNode], lvl: int) -> None:
#         if root == None:
#             return 
        
#         if(root.val == x):
#             self.x_level = lvl
#             self.x_parent = parent
        
#         if(root.val == y):
#             self.y_level = lvl
#             self.y_parent = parent

#         self.dfs(root.left, x, y,root, lvl + 1)
#         self.dfs(root.right, x, y,root, lvl + 1)
        