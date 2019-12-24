# Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Logic

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __dfs(self, node, par):
        if node:
            if par:
                self.depth[node.val] = 1 + self.depth[par.val]
            else:
                self.depth[node.val] = 0
            self.parent[node.val] = par
            self.__dfs(node.left, node)
            self.__dfs(node.right, node)
            
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.parent = {}
        self.depth = {}
        self.__dfs(root, None)
        return self.depth[x] == self.depth[y] and self.parent[x] != self.parent[y]
        