# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __inti__(self):
        xParent = self.xParent
        yParent = self.yParent
        xDepth = self.xDepth
        yDepth = self.yDepth
        
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        
        if root is None:
            return None
        
        self.dfs(root, 0, None,x,y)
        return self.xParent!=self.yParent and self.xDepth==self.yDepth
    
    def dfs(self, root:TreeNode, depth: int, parent: TreeNode, x:int, y:int):
        
#         base
        if root is None:
            return None

#         logic
        
        if root.val == x:
            self.xParent = parent
            self.xDepth = depth
        
        if root.val == y:
            self.yParent = parent
            self.yDepth = depth
    
        self.dfs(root.left,depth+1, root,x,y)
        self.dfs(root.right, depth+1, root,x,y)
        
#  DFS solution, space complexity is O(h) and time complexity is O(n)
        
