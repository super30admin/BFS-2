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
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        queue = collections.deque()
        queue.append((root, 0))
        curr = {}
        while queue:
            (node, level) = queue.popleft()
            if node.left:
                curr[node.left.val] = (node.val, (level + 1))
                queue.append((node.left, (level + 1)))
            if node.right:
                curr[node.right.val]=(node.val, (level + 1))
                queue.append((node.right, (level + 1)))
        if (x not in curr) or (y not in curr): return False
        (x1, x2) = curr[x]
        (y1, y2) = curr[y]
        return (x2 == y2) and (x1 != y1)