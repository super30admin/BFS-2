# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


#checking if the values are having same parents or not and then pushing similar to inorder traversal using queue
from collections import deque
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        q = Deque()
        q.append(root)
        
        while len(q) != 0:
            size = len(q)
            
            x_f = False
            y_f = False
            for i in range(size):
                curr = q.popleft()
                if curr.val == x:
                    x_f = True
                if curr.val == y:
                    y_f = True
                if curr.left != None and curr.right != None:
                    if (curr.left.val == x and curr.right.val == y) or (curr.left.val == y and curr.right.val == x):
                        return False
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
            if x_f and y_f:
                return True
            if x_f or y_f:
                return False
        return False