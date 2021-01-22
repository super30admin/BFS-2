# Created by Aashish Adhikari at 9:56 PM 1/21/2021

'''
Time Complexity:
O(n)

Space Complexity:
Considering the recursion stack, O(height of the recursion tree), else O(1).
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def helper(self, node, level, parent, x, y):

        if node is None:
            return False

        if node.val is not None:
            if node.val == x:
                self.x_parent = parent
                self.x_height = level


            if node.val == y:
                self.y_parent = parent
                self.y_height = level

            self.helper(node.left, level+1, node, x, y)
            self.helper(node.right, level+1, node, x, y)


    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.x_parent = None
        self.y_parent = None
        self.x_height = None
        self.y_height = None
        self.helper(root, 0 , None, x, y)

        return self.x_parent != self.y_parent and self.x_height == self.y_height

