"""
## Problem1 (https://leetcode.com/problems/cousins-in-binary-tree/)
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.

"""
#we need to keep track of parents and depth of x and y
# BFS
#TIME- O(N), SPACE - O(N)
from collections import deque
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root==None:
            return
        q=deque()
        depth={}
        parent={}
        q.append(root)
        depth[root.val]=0
        while q:
            result=[]
            for i in range(len(q)):
                node=q.popleft()
                result.append(node.val)
                if node.left:
                    q.append(node.left)
                    depth[node.left.val] = depth[node.val]+1
                    parent[node.left.val] = node.val
                if node.right:
                    q.append(node.right)
                    depth[node.right.val] = depth[node.val]+1
                    parent[node.right.val] = node.val
        if depth[x] == depth[y] and parent[x]!=parent[y]:
            return True
        else:
            return False



# DFS
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.depth_x = -1
        self.depth_y = -1
        self.parent_x = None
        self.parent_y = None
        self.recur(root, x, y, 0, None)
        return (self.depth_x == self.depth_y) and (self.parent_x != self.parent_y)

    def recur(self, root, x, y, depth, parent):
        if root == None:
            return None

        if root.val == x and self.parent_x == None:
            self.depth_x = depth
            self.parent_x = parent

        if root.val == y and self.parent_y == None:
            self.depth_y = depth
            self.parent_y = parent

        self.recur(root.left, x, y, depth + 1, root)
        self.recur(root.right, x, y, depth + 1, root)


