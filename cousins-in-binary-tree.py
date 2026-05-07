# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        x_parent=None
        y_parent=None

        queue=deque([root])

        while queue:
            level=len(queue)
            for i in range(level):                
                curr=queue.popleft()
                if (curr.left and curr.left.val==x) or (curr.right and curr.right.val==x):
                    x_parent=curr
                if (curr.left and curr.left.val==y) or (curr.right and curr.right.val==y):
                    y_parent=curr

                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            if x_parent and y_parent:
                return x_parent!=y_parent
            if x_parent or y_parent:
                    return False