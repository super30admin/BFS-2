# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# DFS
# TC: O(n)
# SC O(n)
# Normal dfs traversal, while starting from right most node. Entering new level- add the first node encountered(rightmost node)
class Solution:
    def __init__(self):
        # ans array
        self.rightSide = []
    
    def rightSideView(self, root):
        if root == None: return []
        # store level at each node
        self.helper(root, 0)
        return self.rightSide
        
    def helper(self, root, level):
        # base
        if root == None:
            return 
        # logic
        # each new level, aded the node value to ans array
        if level == len(self.rightSide):
            self.rightSide.append(root.val)
        # traverse to next levels
        self.helper(root.right, level+1)
        self.helper(root.left, level+1)

# BFS
# TC: O(n)
# SC: O(n)
# maintain size of each level as always. append the last element of each level to ans array.
from collections import deque
class Solution:
    def rightSideView(self, root):
        res = []
        if root == None: return res
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if i == size -1:
                    res.append(curr.val)
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
        return res
                
        