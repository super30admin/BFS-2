#Time Complexity: O(N)
#Space Complexity: O(h)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.x_lvl = -1
        self.y_lvl = -1
        self.x_parent = None
        self.y_parent = None
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return False
        self.dfs(root,x,y,0,None)
        return self.x_lvl==self.y_lvl and self.x_parent!=self.y_parent
    def dfs(self,root,x,y,lvl,parent):
        if root is None:
            return
        if root.val == x:
            self.x_lvl = lvl
            self.x_parent = parent
        if root.val == y:
            self.y_lvl = lvl
            self.y_parent = parent
        if self.x_parent is None or self.y_parent is None:
            self.dfs(root.left,x,y,lvl+1,root)
            self.dfs(root.right,x,y,lvl+1,root)