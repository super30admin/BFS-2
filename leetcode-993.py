# 993. Cousins in Binary Tree
# https://leetcode.com/problems/cousins-in-binary-tree/

# Tip: Use level order traversal - and if the x/y are found in the same level-  check if there parents are not same => cousins; return true else: return false.
#  T.C: O(n)
#  S.C: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:

        x_parent, y_parent = None, None
        x_found, y_found = False, False
        q = deque()

        if x == root.val or y == root.val:
            return False
        q.append(root)
        
        while q:
            size = len(q)

            if x_found and y_found:
                if x_parent != y_parent:
                    return True
                else:
                    return False
            
            if x_found or y_found:
                return False
            
            for i in range(size):
                
                curr = q.popleft()

                
                if curr.left:
                    if curr.left.val == x:
                        x_found = True
                        x_parent = curr.val

                    if curr.left.val == y:
                        y_found = True
                        y_parent = curr.val
                    q.append(curr.left)
                
                if curr.right:
                    if curr.right.val == x:
                        x_found = True
                        x_parent = curr.val

                    if curr.right.val == y:
                        y_found = True
                        y_parent = curr.val
                    q.append(curr.right)
        return False