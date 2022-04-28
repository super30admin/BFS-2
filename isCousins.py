class Solution:
    xLvl,yLvl = 0,0
    xParent, yParent = None, None
    
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        
        self.helper(None,root,0,x,y)
        return self.xParent != self.yParent and self.xLvl == self.yLvl
        
    def helper(self,parent, root,lvl,x,y):
        if not root:
            return
        
        if root.val == x:
            self.xParent = parent
            self.xLvl = lvl
            
        if root.val == y:
            self.yParent = parent
            self.yLvl = lvl
            
        self.helper(root,root.left, lvl+1,x,y)
        self.helper(root,root.right, lvl+1,x,y)
        
            

        
#     def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
#         res = []
		
#         queue = [(root, None, 0)] 
        
#         while queue:
#             if len(res) == 2:
#                 break
#             node, parent, depth = queue.pop(0)

#             if node.val == x or node.val == y:
#                 res.append((parent, depth))
#             if node.left:
#                 queue.append((node.left, node, depth + 1))
#             if node.right:
#                 queue.append((node.right, node, depth + 1))

#         node_x, node_y = res
		
#         return node_x[0] != node_y[0] and node_x[1] == node_y[1]
        
       