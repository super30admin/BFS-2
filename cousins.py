# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
      q=[]
      parentq=[]

      q.append(root)
      parentq.append(None)

      xFound = None
      yFound = None
      xParent = None
      yParent = None

      while q:
        size = len(q)
        for i in range(size):
          temp1 = q.pop(0)
          temp2 = parentq.pop(0)
          if temp1.val == x:
            xFound = True
            xParent = temp2
          if temp1.val == y:
            yFound = True
            yParent = temp2

          if temp1.left:
            q.append(temp1.left)
            parentq.append(temp1)
          if temp1.right:
            q.append(temp1.right)
            parentq.append(temp1)

        if xFound and yFound:
          return xParent!=yParent
        if xFound or yFound:
          return False
      return False