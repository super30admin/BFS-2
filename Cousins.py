#Time Complexity: O(n)
#Space Complexity: O(h)
# Cousins in a tree are at same level but have different parents. If they have same parent then they are siblings not cousins

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_parent = None
        self.y_parent = None
        self.x_height = 0
        self.y_height = 0
        self.DFS(root, 0, x, y,None)
        if self.x_parent and self.y_parent and self.x_parent != self.y_parent and self.x_height == self.y_height:
            return True
        return False

    def DFS(self, root, depth, x, y, parent):
        # Base case
        if root is None:
            return

        # Logic
        if root.val==x:
            self.x_height=depth
            self.x_parent=parent
        elif root.val==y:
            self.y_height=depth
            self.y_parent=parent
        if root.left:
            self.DFS(root.left, depth+1, x, y, root)
        if root.right:
            self.DFS(root.right, depth+1, x, y, root)
