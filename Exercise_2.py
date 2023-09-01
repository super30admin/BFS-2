# Problem 2

# Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)
# // Time Complexity : O(n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# DFS approach


# class Solution:
#     def isCousins(self, root, x, y):
#         # if no root present
#         if not root:
#             return False
#         # Creating global variables representing parents and depths
#         self.x_parent = None
#         self.y_parent = None
#         self.x_depth = None
#         self.y_depth = None
#         self.dfs(root, x, y, 0)
#         # if parents are different but depth is same
#         return self.x_depth == self.y_depth and self.x_parent != self.y_parent

#     def dfs(self, root, x, y, depth, parent=None):
#         # if root not present
#         if not root:
#             return
#         # cheking if val is = x
#         if root.val == x:
#             self.x_parent = parent
#             self.x_depth = depth
#         # cheking if val is = y
#         if root.val == y:
#             self.y_parent = parent
#             self.y_depth = depth
#         self.dfs(root.left, x, y, depth, root)
#         self.dfs(root.right, x, y, depth, root)


# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach

# BFS Approach
class Solution:
    def isCousins(self, root, x, y):
        # if no root present
        if not root:
            return False
        # creating 2 queues
        # child queue
        q = deque([root, ])
        pq = deque([None, ])
        # parent queue
        # while elements are present in q
        while q:
            # variables for if x and y are found
            x_found = False
            y_found = False
            x_parent = None
            y_parent = None
            # level length
            size = len(q)
            # for each level
            for i in range(size):
                # pop left most element
                curr = q.popleft()
                # pop left most element from parent queue
                currP = pq.popleft()
                # if x found
                if curr.val == x:
                    x_found = True
                    # storing parent
                    x_parent = currP
                # if y found
                if curr.val == y:
                    y_found = True
                    # storing parent
                    y_parent = currP
                # adding childern to q
                if curr.left:
                    q.append(curr.left)
                    # adding parent to pq
                    pq.append(curr)
                if curr.right:
                    q.append(curr.right)
                    # adding parent to pq
                    pq.append(curr)
            if x_found and y_found:
                return (x_parent != y_parent)
            if x_found or y_found:
                return False


sol = Solution()
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.right = TreeNode(4)
root.right.right = TreeNode(5)

print(sol.isCousins(root, x=4, y=5))
