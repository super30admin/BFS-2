# Time Complexity : O(n), where n is the number of nodes in the tree.
# Space Complexity: O(h), where h is the height of the tree.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class Solution(object):
    # This problem is solved using a simple dfs approach to find both
    # x and y, their respective depths and parents. if the two exist
    # at same depth with different parent's return True, else return False.
    def __init__(self):
        self.xdepth, self.ydepth = -1, -1
        self.xparent, self.yparent = -1, -1
        self.x, self.y = -1, -1

    def isCousins(self, root, x, y):
        if not root:
            return False
        # global vars assignment
        self.x, self.y = x, y
        self.dfs(root, 0, root)
        # logic of the problem
        if self.xdepth == self.ydepth and self.xparent != self.yparent:
            return True
        return False

    def dfs(self, root, depth, parent):
        # base
        if not root:
            return
        # logic
        if root.val == self.x:
            self.xdepth = depth
            self.xparent = parent.val
        if root.val == self.y:
            self.ydepth = depth
            self.yparent = parent.val
        # recursive calls to children nodes.
        self.dfs(root.left, depth + 1, root)
        self.dfs(root.right, depth + 1, root)
