# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root) :
        result = []

        if root is None:
            return []

        queue = []
        queue.append(root)

        while len(queue) != 0:
            sz = len(queue)
            for i in range(sz):
                curr = queue.pop(0)

                if (i == sz - 1):
                    result.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)

        return result