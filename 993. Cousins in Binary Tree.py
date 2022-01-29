# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# time complexity: O(n)
# space complexity: O(n)

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_parent=TreeNode(None)
        self.y_parent=TreeNode(None)
        self.x_level=None
        self.y_level=None
        
        if root==None: return False
        
        def dfs(root, x, y, lvl, parent):
            #base
            if root==None:
                return
            #logic
            if root.val==x:
                self.x_parent=parent
                self.x_level=lvl
                
            if root.val==y:
                self.y_parent=parent
                self.y_level=lvl
                
            dfs(root.left, x, y, lvl+1, root)
            dfs(root.right, x, y, lvl+1, root)
        
        dfs(root, x, y, 0, None)
        ans=(self.x_parent!=self.y_parent and self.x_level==self.y_level)
        return ans