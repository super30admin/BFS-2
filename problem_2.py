# Time Complexity : O(n)
# Space Complexity : O(n/2) --> O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Using BFS
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isCousins(self, root, x: int, y: int) -> bool:
        queue = deque()
        queue.append(root)
        flagx = False
        flagy = False
        while queue:
            size = len(queue)
            for i in range(size):
                pop = queue.popleft()
                if pop.left and pop.right:
                    if (pop.left.val == x or pop.left.val == y) and (pop.right.val == x or pop.right.val == y):
                        return False
                if pop.val == x:
                    flagx = True
                elif pop.val == y:
                    flagy = True
                if pop.left:
                    queue.append(pop.left)
                if pop.right:
                    queue.append(pop.right)
            if flagx == True and flagy == True:
                return True
            if flagx or flagy:
                return False


check = TreeNode(1)
check.left = TreeNode(2)
check.right = TreeNode(3)
check.left.right = TreeNode(4)
check.right.right = TreeNode(5)
print(Solution().isCousins(check, 4, 5))


# Using BFS
# from collections import deque
#
#
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def isCousins(self, root, x: int, y: int) -> bool:
#         xinfo = [0, 0]
#         yinfo = [0, 0]
#         queue = deque()
#         parent = deque()
#         queue.append(root)
#         parent.append(-1)
#         count = 0
#         while queue and (not xinfo[0] or not yinfo[0]):
#             size = len(queue)
#             for i in range(size):
#                 pop = queue.popleft()
#                 parentf = parent.popleft()
#                 if pop.left:
#                     queue.append(pop.left)
#                     parent.append(pop.val)
#                 if pop.right:
#                     queue.append(pop.right)
#                     parent.append(pop.val)
#                 if pop.val == x:
#                     xinfo = [parentf, count]
#                 if pop.val == y:
#                     yinfo = [parentf, count]
#             if (xinfo[0] != 0 and yinfo[0] == 0) or (yinfo[0] != 0 and xinfo[0] == 0):
#                 return False
#             count += 1
#         if xinfo[0] != yinfo[0] and xinfo[1] == yinfo[1]:
#             return True
#
#
# check = TreeNode(1)
# check.left = TreeNode(2)
# check.right = TreeNode(3)
# check.left.right = TreeNode(4)
# check.right.right = TreeNode(5)
# print(Solution().isCousins(check, 4, 5))


# Using DFS
# TC: O(n); SC - O(h)
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.xinfo = [0, 0]
#         self.yinfo = [0, 0]
#
#     def helper(self, root, level, prev):
#         if root is None:
#             return
#         if root.val == self.x:
#             self.xinfo = [prev.val, level]
#         if root.val == self.y:
#             self.yinfo = [prev.val, level]
#         if self.xinfo[0] == 0 or self.yinfo[0] == 0:
#             self.helper(root.left, level + 1, root)
#         if self.xinfo[0] == 0 or self.yinfo[0] == 0:
#             self.helper(root.right, level + 1, root)
#
#     def isCousins(self, root, x: int, y: int) -> bool:
#         self.x = x
#         self.y = y
#         self.helper(root, 0, root)
#         if self.xinfo[0] != self.yinfo[0] and self.xinfo[1] == self.yinfo[1]:
#             return True
#         return False
#
#
# check = TreeNode(1)
# check.left = TreeNode(2)
# check.right = TreeNode(3)
# check.left.right = TreeNode(4)
# check.right.right = TreeNode(5)
# print(Solution().isCousins(check, 4, 5))
