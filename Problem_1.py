# Runs on Leetcode

# DFS
    # Runtime - O(n)
    # Memory - O(1)

# BFS
    # Runtime - O(n)
    # Memory - O(n)


class Solution:
    def DFS_isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        self.x = x
        self.y = y
        self.helper(root, 0, TreeNode(-1))
        return self.xp != self.yp and self.depth_x == self.depth_y
    
    def helper(self,root,depth,parent):
        if root is None:
            return 
        if root.val == self.x:
            self.xp = parent.val
            self.depth_x = depth
        if root.val == self.y:
            self.yp = parent.val
            self.depth_y = depth
        if root.left:
            self.helper(root.left, depth+1, root)
        if root.right:
            self.helper(root.right, depth+1, root)
