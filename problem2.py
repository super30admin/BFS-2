#Time Complexity :O(N)
#Space Complexity :O(N)
#Did this code successfully run on Leetcode :yes
#Method: BFS

# Definition for a binary tree node.
import collections


class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def isCousins(self, root: [TreeNode], x: int, y: int) -> bool:
        if root is None:
            return False

        q = collections.deque()
        q.append(root)

        while q:
            qlen = len(q)
            x_parent = None
            y_parent = None

            for i in range(qlen):
                curr = q.popleft()

                if curr.left:
                    q.append(curr.left)
                    if curr.left.val == x:
                        x_parent = curr
                    if curr.left.val == y:
                        y_parent = curr

                if curr.right:
                    q.append(curr.right)
                    if curr.right.val == x:
                        x_parent = curr
                    if curr.right.val == y:
                        y_parent = curr

            if x_parent and y_parent and x_parent != y_parent:
                return True

            if (x_parent and not y_parent) or (not x_parent and y_parent):
                return False

        return False

