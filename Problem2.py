#Time complexity: O(n)
#Space complexity: O(h)

#Accepted on Leetcode

#Approach:
#DFS Approach, Keep track of xParent, yParent, xLevel and yLevel and assign them whenever x and y found
#At the end, return true/false depending on whether parents/levels are same or not

#BFS Approach
#At each level, for each node check if: 1)current node's children are not x and y (or y and x) - if they are then return false since they are siblings 2) check if current node is x or y.
#At the end of a level, check if x and y found -> if they are found then return true since it means they are on the same level


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    xLevel = yLevel = None
    xParent = yParent = None
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:


        self.dfs(root, None,x, y, 0)
        if self.xParent != self.yParent:
            return self.xLevel == self.yLevel
        
        return False
    
    def dfs(self, root, parent, x, y, level):
        if (root == None) or (self.xParent and self.yParent):
            return

        if root.val == x:
            self.xParent = parent
            self.xLevel = level
        elif root.val == y:
            self.yParent = parent
            self.yLevel = level
        
        self.dfs(root.left,root,x,y, level+1)
        self.dfs(root.right,root,x,y, level + 1)

        