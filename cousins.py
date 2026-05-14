# Time Complexity : O(n)
# Space complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Keep missing the edge conditions.

# Your code here along with comments explaining your approach
# Using a queue to perform BFS and resetting FlagX and FlagY trackers at the beginning of every new depth level.
# check its left and right children, if it is the parent to both x and y, return False immediately.
# Once a level is fully processed, return True if both targets were found, return False if only one was found or continue searching if neither were found

from collections import deque
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        if not root:
            return False

        q = deque()
        q.append(root)


        while q:
            size = len(q)
            FlagX = False
            FlagY = False
            for i in range(size):
                curr = q.popleft()
                
                if curr.val == x:
                    FlagX = True
                if curr.val == y:
                    FlagY = True

                if curr.right and curr.left:
                    if (curr.right.val == x and curr.left.val == y) or (curr.right.val == y and curr.left.val == x):
                        return False

                if curr.right:
                    q.append(curr.right)
                if curr.left:
                    q.append(curr.left)
            if FlagX and FlagY:
                return True
            if FlagX or FlagY:
                return False
        return False
        