"""
Problem: Cousins in Binary Tree
Approach: if the children of current node = x and y then return False as they are siblings. 
else if two nodes are found in the same level then return True. Can use BFS for level by level
traversal
t.c. => O(n)
s.c. => O(n)

"""
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False

        q = deque()
        q.append(root)

        while q:
            numFound = 0
            for i in range(len(q)):
                parent = q.popleft()
                l = parent.left
                if l:
                    q.append(parent.left)
                
                r = parent.right
                if r:
                    q.append(parent.right)
                
                if l and r and( (l.val == x and r.val == y) or (l.val == y and r.val == x )):
                    return False
                if parent.val == x or parent.val == y:
                    numFound += 1
            if numFound == 2:
                return True
        return False
            

            