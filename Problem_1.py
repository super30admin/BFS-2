# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

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
        def dfs(root, num, level):
            if not root:
                return
            if (root and level) == len(num):
                num.append(root.val)
            dfs(root.right, num, (level + 1))
            dfs(root.left, num, (level + 1))
            return num
        return dfs(root, [], 0)