# Time: O(N)
# Space: O(N)


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def __init__(self):
        self.x_depth, self.y_depth, self.x_parent, self.y_parent = None, None, None, None
        self.x_flag, self.y_flag = None, None

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:

        # pass root,parent(since we need to know cousin),x and y, and depth
        self.dfs(root, None, x, y, 0)
        # check qualifying conditions for being cousins
        return (self.x_parent != self.y_parent) and (self.x_depth == self.y_depth)

    def dfs(self, root, parent, x, y, depth):
        if root is None:
            return
        if root.val == x:
            self.x_depth = depth
            self.x_parent = parent
            self.x_flag = True
        if root.val == y:
            self.y_depth = depth
            self.y_parent = parent
            self.y_flag = True
        if self.x_flag and self.y_flag:
            # if x and y found break the recursion early
            return
        else:
            self.dfs(root.left, root, x, y, depth + 1)
            self.dfs(root.right, root, x, y, depth + 1)
