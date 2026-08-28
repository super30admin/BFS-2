#Time Complexity: O(n)
#Space Complexity: O(n)

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
        """self.x_level = -1
        self.y_level = -1
        self.x_parent = None
        self.y_parent = None

        def helper(node, level, parent):
            if node is None:
                return

            if node.val == x:
                self.x_level = level
                self.x_parent = parent

            if node.val == y:
                self.y_level = level
                self.y_parent = parent

            if self.x_parent is None or self.y_parent is None:
                helper(node.left, level + 1, node)

            if self.x_parent is None or self.y_parent is None:
                helper(node.right, level + 1, node)

        helper(root, 0, None)
        return self.x_level == self.y_level and self.x_parent != self.y_parent
        """
        self.val, self.left, self.right = 0, None, None

        q = deque()
        q.append(root)
        x_found, y_found = False, False

        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()

                if curr.left is not None and curr.right is not None:
                    if curr.left.val == x and curr.right.val == y: return False
                    if curr.right.val == x and curr.left.val == y: return False

                if curr.val == x: x_found = True
                if curr.val == y: y_found = True

                if curr.left is not None: q.append(curr.left)
                if curr.right is not None: q.append(curr.right)

            if x_found and y_found: return True
            if x_found or y_found: return False

        return True