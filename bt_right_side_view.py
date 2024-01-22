""" Explanation: We use BFS to traverse all levels of the binary tree. Then at each level, we append the root to the queue and pop the first
    element. Queue being the FIFO data structures, pops the left node and then we add the right node from the queue to the list. 
    Time Complexcity: O(n)
    Space Complexcity: O(h)
"""

from collections import deque


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []

        result = []
        queue = deque([root])

        while queue:
            level_size = len(queue)

            # Traverse the current level - BFS
            for i in range(level_size):
                node = queue.popleft()

                # Update the result with the rightmost node's value
                if i == level_size - 1:
                    result.append(node.val)

                # Add child nodes to the queue for the next level
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return result
        