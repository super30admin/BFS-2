# Time Complexity :O(n)
# Space Complexity :O(width)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 993

# In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
#
# Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
#
# We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
#
# Return true if and only if the nodes corresponding to the values x and y are cousins.
#
# Input: root = [1,2,3,4], x = 4, y = 3
# Output: false

# Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
# Output: true

# Input: root = [1,2,3,null,4], x = 2, y = 3
# Output: false

from collections import deque


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """

        res = []

        queue = deque()
        queue.append([root, None, 0])

        while queue:

            currNode, parent, depth = queue.popleft()
            if currNode.val == x or currNode.val == y:
                res.append((parent, depth))

            if currNode.left:
                queue.append([currNode.left, currNode, depth + 1])
            if currNode.right:
                queue.append([currNode.right, currNode, depth + 1])

        return res[0][0] != res[1][0] and res[0][1] == res[1][1]

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.right = TreeNode(5)
root.right.right = TreeNode(4)

print(Solution().isCousins(root,5,4))