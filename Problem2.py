##Time Complexity :- O(n)
#Space Complexity :- O(n)
#Approach :- Used BFS and checked stored the parent in child if it matches with x and y and then check for parent if equal return false else return true
# 
#  Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import math
class Solution:
    
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        parentNodeXLevel = []
        parentNodeYLevel = []
        queue = []
        queue.append(root)
        while len(queue) > 0:
            if len(parentNodeXLevel)>0 and len(parentNodeYLevel)>0:
                if parentNodeXLevel[1] != parentNodeYLevel[1]:
                    return True
                else:
                    return False
            if (len(parentNodeXLevel)>0 and len(parentNodeYLevel) == 0) or (len(parentNodeXLevel)==0 and len(parentNodeYLevel) > 0):
                return False

            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                if curr.left:
                    if curr.left.val == x:
                        parentNodeXLevel.append(x)
                        parentNodeXLevel.append(curr.val)
                    if curr.left.val == y:
                        parentNodeYLevel.append(y)
                        parentNodeYLevel.append(curr.val)
                    queue.append(curr.left)
                if curr.right:
                    if curr.right.val == x:
                        parentNodeXLevel.append(x)
                        parentNodeXLevel.append(curr.val)
                    if curr.right.val == y:
                        parentNodeYLevel.append(y)
                        parentNodeYLevel.append(curr.val)
                    queue.append(curr.right)



## Optional Approach used : DFS to store the parent and level and once root is null then returned the value 
# Time Complexity : O(n)
#  Space Complexity : O(h)          

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    xParent = None
    yParent = None
    xLevel = None 
    yLevel = None
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.xParent = None
        self.yParent = None
        self.xLevel = None 
        self.yLevel = None
        
        self.dfs(root, None, 0, x , y)
        if self.xParent != self.yParent and self.xLevel == self.yLevel:
            return True
        return False

    def dfs(self, root, parent, level, x, y):
        if root is None:
            return

        if root.val == x : 
            self.xParent = parent
            self.xLevel = level
        if root.val == y:
            self.yParent = parent
            self.yLevel = level
          
        if self.xParent is  None  or self.yParent is  None:
            self.dfs(root.left, root.val, level+1, x, y)
        if self.xParent is None or self.yParent is  None:
            self.dfs(root.right, root.val, level+1, x, y)
        
        


