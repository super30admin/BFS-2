"""
Problem: 993. Cousins in Binary Tree
Leetcode: https://leetcode.com/problems/cousins-in-binary-tree/
Time Complexity: O(N), N is the number of nodes in the binary tree
Space Complexity: O(N). This is because the maximum amount of space utilized by the recursion stack would be N, as the height of a skewed binary tree could be, at worst, N
"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from collections import deque


class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        # base case
        if not root:
            return True

        # queue for BFS
        queue = collections.deque([root])

        while queue:
            qsize = len(queue)
            is_x_found = False
            is_y_found = False
            for i in range(qsize):
                curr = queue.popleft()
                if curr.val == x: is_x_found = True
                if curr.val == y: is_y_found = True

                # if x and y had same parent i.e. they're siblings
                if curr.left is not None and curr.right is not None:
                    if (curr.left.val == x and curr.right.val == y) or (curr.left.val == y and curr.right.val == x): return False

                # else add nodes to the queue
                if curr.left is not None: queue.append(curr.left)
                if curr.right is not None: queue.append(curr.right)

            # if x and y are found at the same level and they do not have same parent
            if is_x_found and is_y_found: return True

        # we're here because x and y are not cousins
        return False