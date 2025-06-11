# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional['TreeNode'], x: int, y: int) -> bool:
        if not root:
            return False
        queue = deque([(root, None)])  # (node, parent)
        while queue:
            size = len(queue)
            x_parent = y_parent = None
            for _ in range(size):
                node, parent = queue.popleft()
                if node.val == x:
                    x_parent = parent
                if node.val == y:
                    y_parent = parent
                if node.left:
                    queue.append((node.left, node))
                if node.right:
                    queue.append((node.right, node))
            if x_parent and y_parent:
                return x_parent != y_parent
            if x_parent or y_parent:
                return False
        return False
        