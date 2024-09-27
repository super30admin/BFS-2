# Accepted on leetcode(993)
# time - O(N), space - O(1)
# We use 4 global variables here xparent and yparent which should not be equal and xdepth and ydepth which should be equal.
# In the helper function save parent and depth of each node and as a base case compare each node with x and y and if found save their depth and parent and return it to main function
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    # Global variables
    x_parent = TreeNode(None)
    y_parent = TreeNode(None)
    x_depth = -1
    y_depth = -1

    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        # initial call to helper
        self.helper(root, x, y, 0, None)
        # boolean answer
        return (Solution.x_depth == Solution.y_depth and Solution.x_parent != Solution.y_parent)

    def helper(self, root, x, y, depth, parent):
        # edge case
        if not root: return
        # base case
        if root.val == x:  # if x found
            Solution.x_parent = parent
            Solution.x_depth = depth
        if root.val == y:  # if y found
            Solution.y_parent = parent
            Solution.y_depth = depth

        # moving to left and right subtree.
        self.helper(root.left, x, y, depth + 1, root)
        self.helper(root.right, x, y, depth + 1, root)