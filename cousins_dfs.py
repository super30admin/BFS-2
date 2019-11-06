# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    xParent = None
    xHeight = None
    yParent = None
    yHeight = None
    def dfs(self,node,x,y,height) :
        if not node :
            return
        
        if (node.left and (node.left.val == x)) or (node.right and (node.right.val == x)) :
            self.xParent = node
            self.xHeight = height
        
        if (node.left and (node.left.val == y)) or (node.right and (node.right.val == y)) :
            self.yParent = node
            self.yHeight = height
        
        if self.xParent and self.yParent :
            return 
        
        if node.left :
            self.dfs(node.left,x,y,height+1)

        if self.xParent and self.yParent :
            return 
        
        if node.right :
            self.dfs(node.right,x,y,height+1)
        

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.xParent = None
        self.yParent = None
        self.xHeight = None
        self.yHeight = None
        self.dfs(root,x,y,0)
        return (self.xParent != self.yParent) and (self.xHeight == self.yHeight)
