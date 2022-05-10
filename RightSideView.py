# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []

        def recursion(node, level):
            if not node:
                return
            if len(result) == level:
                result.append(node.val)
            recursion(node.right, level + 1)
            recursion(node.left, level + 1)

        recursion(root, 0)
        return result
