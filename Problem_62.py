# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# ########## DFS Solution O(n) time and O(h) space ######

# class Solution:
#     def __init__(self):
#         self.x_parent = None
#         self.y_parent = None
#         self.x_height = 0
#         self.y_height = 0
    
#     def dfs(self,root,x,y,depth,parent):
#         if not root:
#             return
#         if root.val == x:
#             self.x_parent = parent
#             self.x_height = depth

#         if root.val == y:
#             self.y_parent = parent
#             self.y_height = depth
        
#         self.dfs(root.left,x,y,depth+1,root)
#         self.dfs(root.right,x,y,depth+1,root)
        
#     def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
#         if not root:
#             return False
        
#         self.dfs(root,x,y,0,None)
        
#         return (self.x_parent != self.y_parent) and (self.x_height == self.y_height)


################## BFS Solution O(n) time and O(n) space ######################
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        
        q = collections.deque()
        q.appendleft(root)
        
        # print(q)
        while q:
            size = len(q)
            x_found = False
            y_found = False
            
            for i in range(size):
                curr = q.pop()
                
                if curr.left and curr.right:
                    if((curr.left.val == x and curr.right.val == y) or (curr.left.val == y and curr.right.val == x)):
                        return False # x and y are siblings
                
                if curr.val == x:
                    x_found = True
                
                if curr.val == y:
                    y_found = True
                    
                if curr.left:
                    q.appendleft(curr.left)
                if curr.right:
                    q.appendleft(curr.right)
                
            if x_found and y_found:
                return True # If they are both true, they are also cousins as we were returning false if they were siblings earlier
            if x_found or y_found:
                return False
        
        return False
                
                    
                    