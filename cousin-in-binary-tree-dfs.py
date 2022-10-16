# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC: O(n)
# SC: O(h)
class Solution:
    def __init__(self):
        self.xParent = None
        self.yParent = None
        self.xLevel = None
        self.yLevel = None

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None or x == y:
            return False

        self.dfs(root, x, y, None, 0)
        return self.xParent != self.yParent and self.xLevel == self.yLevel

    def dfs(self, root, x, y, parent, level):
        #base
        if root == None:
            return

        # logic
        if x == root.val:
            self.xParent = parent
            self.xLevel = level
        if y == root.val:
            self.yParent = parent
            self.yLevel = level
        
        if self.xParent is None or self.yParent is None:
            self.dfs(root.left, x, y, root, level+1)
            self.dfs(root.right, x, y, root, level+1)


