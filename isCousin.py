# Definition for a binary tree node.
# LeetCode 993

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    xdep = -1
    ydep = -1
    xpar = None
    ypar = None
    def isCousins(self, root, x, y):

        # xpar=TreeNode(None)
        # ypar=TreeNode(None)
        self.finddepthAndParent(root, 0, x, y, None)
        return self.xdep == self.ydep and self.xpar != self.ypar
    def finddepthAndParent(self, root, depth, x, y, parent):
        if root == None:
            return
        if root.val == x:
            self.xpar = parent
            self.xdep = depth
        if root.val == y:
            self.ypar = parent
            self.ydep = depth
        self.finddepthAndParent(root.left, depth + 1, x, y, root)
        self.finddepthAndParent(root.right, depth + 1, x, y, root)
obj = Solution()
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.right = TreeNode(4)
root.right.right = TreeNode(5)
print(obj.isCousins(root, 5,4))
