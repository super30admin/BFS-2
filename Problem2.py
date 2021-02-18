
# Time Complexity :O(n)
# Space Complexity :O(width)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 199

# Given the root of a binary tree, imagine yourself standing on the right side of it,
# return the values of the nodes you can see ordered from top to bottom.

# Input: root = [1,2,3,null,5,null,4]
# Output: [1,3,4]
#
# Input: root = [1,null,3]
# Output: [1,3]

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
            return

        queue = deque()
        queue.append(root)
        res = []
        while queue:
            queueSize = len(queue)
            for i in range(queueSize):
                node = queue.popleft()
                if i == queueSize - 1:
                    res.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return res

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.right = TreeNode(5)
root.right.right = TreeNode(4)

print(Solution().rightSideView(root))
