#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(n) i.e. number of nodes added in the stack
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=iICZEF2BN24&ab_channel=%7BS30%7D
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    xparent = TreeNode()
    yparent = TreeNode() 
    x_height = int()
    y_height = int()
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        #null conditions
        if root == None:
            return false
        self.dfs(root, None, 0, x,y)
        #if parents of s and y are different and both the node are at same height then they are cousins
        return self.xparent != self.yparent and self.x_height == self.y_height
    
    def dfs(self, root : TreeNode, parent: TreeNode, level:int, x: int, y: int):
        #base condition
        if root == None:
            return
        #logic
        if root.val == x:
            self.xparent = parent
            self.x_height = level
        if root.val == y:
            self.yparent = parent
            self.y_height = level
        self.dfs(root.left, root, level+1, x,y)
        self.dfs(root.right, root, level+1, x,y)
