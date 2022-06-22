# Using BFS
# TC: O(n); SC: O(n/2) --> O(n)
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def leftSideView(self, root):
        queue = deque()
        queue.append(root)
        result = []
        while queue:
            size = len(queue)
            result.append(queue[0].val)
            for i in range(size):
                pop = queue.popleft()
                if pop.left:
                    queue.append(pop.left)
                if pop.right:
                    queue.append(pop.right)
        return result


check = TreeNode(1)
check.left = TreeNode(2)
check.right = TreeNode(3)
check.left.left = TreeNode(4)
check.left.right = TreeNode(6)
check.right.right = TreeNode(5)
check.right.right.right = TreeNode(7)
print(Solution().leftSideView(check))


# Using DFS
# TC - O(n); SC - O(h)
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.result = []
#
#     def helper(self, root, level):
#         if root is None:
#             return
#         if len(self.result) == level:
#             self.result.append(root.val)
#         self.helper(root.left, level+1)
#         self.helper(root.right, level+1)
#
#     def leftSideView(self, root):
#         if root is None:
#             return
#         self.helper(root, 0)
#         return self.result
#
#
# check = TreeNode(1)
# check.left = TreeNode(2)
# check.right = TreeNode(3)
# check.left.left = TreeNode(4)
# check.left.right = TreeNode(6)
# check.right.right = TreeNode(5)
# check.right.right.right = TreeNode(7)
# print(Solution().leftSideView(check))
