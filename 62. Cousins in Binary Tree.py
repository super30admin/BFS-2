# Time Complexity: O(n)
# Space Complexity: O(n)

# ------------------------------------BFS-------------------------------------
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = []
        queue.append(root)
        while len(queue) != 0:
            x_boolean = False
            y_boolean = False
            size = len(queue)
            for i in range(size):
                newroot = queue.pop(0)
                if newroot.val == x: x_boolean = True 
                if newroot.val == y: y_boolean = True
                
                if newroot.left != None and newroot.right != None:
                    if newroot.left.val == x and newroot.right.val == y: return False 
                    if newroot.left.val == y and newroot.right.val == x: return False
                if newroot.left != None: queue.append(newroot.left)
                if newroot.right != None: queue.append(newroot.right)
            if x_boolean and y_boolean: return True
            if x_boolean or y_boolean: return False
        return False


# ----------------------------------DFS--------------------------------------
# class Solution:
#     def __init__(self):
#         self.x_parent = None
#         self.y_parent = None
#         self.x_depth = 0
#         self.y_depth = 0
        
#     def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
#         self.dfs(root, x, y, None, 0)
#         return self.x_depth == self.y_depth and self.x_parent != self.y_parent
    
#     def dfs(self, root, x, y, parent, depth):
#         #base
#         if root is None: return 
        
#         #logic
#         if root.val == x:
#             self.x_parent = parent
#             self.x_depth = depth
#         if root.val == y:
#             self.y_parent = parent
#             self.y_depth = depth
#         self.dfs(root.left, x, y, root, depth+1)
#         self.dfs(root.right, x, y, root, depth+1)