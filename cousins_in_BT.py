# Leetcode 993. Cousins in Binary Tree

# Time Complexity :  O(n) where n is the number of the nodes

# Space Complexity : O(n) where n is the number of the nodes

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use a queue to process level by level. If either x or y is found on the level mark the flag
# as true. Else check if the left and right child nodes match x and y. If they match then they are siblings,
# so return False. Store the left and right child into the queue if none of the above conditions are met.
# At the end of each level check if x and y are found. If yes then it means they are cousins return true.
# If they are not found then return false when the queue is empty.

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        q = deque()
        q.append(root)
        # While q with same level diff parent nodes is not empty
        while q:
            size = len(q)
            x_found = False
            y_found = False
            # Iterating on the first level in Q
            for _ in range(size):
                node = q.popleft()
                # Checking if the value appears in the current level
                if node.val == x:
                    x_found = True
                if node.val == y:
                    y_found = True
                # Checking if the values dont match for same parent
                if node.left and node.right:
                    if (node.left.val == x and node.right.val == y):
                        return False
                    if (node.left.val == y and node.right.val == x):
                        return False
                # Adding elements in same level but diff parents to Q
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            # If x and y are found on same level and as they dont belong to same parent
            # return True
            if x_found and y_found:
                return True
        # if not found at any level return false
        return False
