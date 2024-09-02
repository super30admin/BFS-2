# BFS-2

## Problem 1 Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []

        self.result = []
        self.dfs(root, 0)
        return self.result

    def dfs(self, root: Optional[TreeNode], lvl : int) ->None:
        #base
        if root == None:
            return

        #logic
        if lvl == len(self.result) :
            self.result.append(root.val)
        else:
            self.result[lvl] = root.val

        self.dfs(root.left , lvl + 1)
        self.dfs(root.right , lvl + 1)
# TC = O(n), SC = O(h)
        

## Problem 2 Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None:
            return False

        self.x_parent = None
        self.x_lvl = -1
        self.y_parent = None
        self.y_lvl = -1
        self.dfs(root, 0, None , x , y)
        return self.x_parent != self.y_parent and self.x_lvl == self.y_lvl

    def dfs(self, root: Optional[TreeNode],lvl : int , parent : Optional[TreeNode] ,  x: int, y: int):
        #base
        if root == None or (self.x_parent != None and self.y_parent != None):
            return

        #logic
        if root.val == x:
            self.x_parent = parent
            self.x_lvl = lvl

        if root.val == y:
            self.y_parent = parent
            self.y_lvl = lvl

        #recursion
        self.dfs(root.left , lvl + 1 , root , x , y)
        self.dfs(root.right , lvl + 1 , root , x , y)
# TC = O(n), SC = O(h)
        



