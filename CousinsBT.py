# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# DFS
# TC: O(n)
# SC: O(n)
# We store parent and level at each node. Record x & y parents and depths. At the end we check condition required for those nodes to be cousins
class Solution:
    def __init__(self):
        self.xParent = None
        self.yParent = None
        self.xDepth = None
        self.yDepth = None

    def isCousins(self, root, x, y):
        self.dfs(root, None, 0, x, y)
        return self.xParent != self.yParent and self.xDepth == self.yDepth
    
    def dfs(self, root, parent, depth, x, y):
        # base
        if root == None: return 
        
        if root.val == x:
            self.xParent = parent
            self.xDepth = depth
        
        if root.val == y:
            self.yParent = parent
            self.yDepth = depth
        
        self.dfs(root.left, root, depth + 1, x, y)
        self.dfs(root.right, root, depth + 1, x, y)
        
# BFS
# TC: O(n)
# SC: O(n)
# Maintain size of queue at the start of loop- that defines level size. Keep x n y found flags. Before appending child nodes to queue check if they are x n y, they have same parent- return False. At the end we check the flags to determine cousin or not!
from collections import deque
class Solution:
    def isCousins(self, root, x, y):
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            xFound = False
            yFound = False
            for i in range(size):
                curr = q.popleft()
                if curr.val == x: xFound = True
                if curr.val == y: yFound = True
                if curr.left != None and curr.right != None:
                    if curr.left.val == x and curr.right.val == y: return False
                    if curr.right.val == x and curr.left.val == y: return False
                if curr.left != None: q.append(curr.left)
                if curr.right != None: q.append(curr.right)
            if xFound and yFound: return True
            if xFound or yFound: return False
        return False
