"""
Time Complexity : O(n)
Space Complexity : O(h)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


We can do this by both DFS and BFS.I have commented the BFS solution. For DFS, we need to maintain 4 
variables, ie xparent,yparent,xdepth and ydepth. We will call DFS on root. At every node we will check the value
of root with x and y.If we found one, we will update the value of the 4 variables respectively.
Once DFS is done, we need to check if parents are different but depth is same and will return the same.
For BFS, we need to maintain a queue and keep track of size as we need to check nodes at the same level.
For every level, we will keep 2 boolean variables, xfound and yfound. When we pop out a node from a queue
and see its children, if they are equal to x and y, we can return false then and there. If not, we will 
add them to the queue. Also, while popping out from the queue, we will check if value of root node
is equal to x or y. If yes, we will update the respective boolean variable. Once we come out of for loop, we can 
compare xfound and yfound . If both are true, then they are siblings and we return True.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.xparent = TreeNode()
        self.yparent = TreeNode()
        self.xdepth = -1
        self.ydepth = -1
        self.dfs(root, None, 0, x, y)
        return self.xparent != self.yparent and self.xdepth == self.ydepth

    def dfs(self, root, parent, depth, x, y):
        if not root:
            return
        if root.val == x:
            self.xparent = parent
            self.xdepth = depth
        if root.val == y:
            self.yparent = parent
            self.ydepth = depth
        self.dfs(root.left, root, depth+1, x, y)
        self.dfs(root.right, root, depth+1, x, y)
# from collections import deque
# class Solution:
#     def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
#         q=deque()
#         q.append(root)
#         while q:
#             size=len(q)
#             xfound=False
#             yfound=False
#             for i in range(size):
#                 a=q.popleft()
#                 if a.val==x:
#                     xfound=True
#                 if a.val==y:
#                     yfound=True
#                 if a.left and a.right:
#                     left=a.left.val
#                     right=a.right.val
#                     if (left==x and right==y) or (left==y and right==x):
#                         return False
#                 if a.left:
#                     q.append(a.left)
#                 if a.right:
#                     q.append(a.right)
#             if xfound and yfound:
#                 return True
#         return False
