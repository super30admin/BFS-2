# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
      if root==None:
        return False
      
      q=deque()
      xvalue=True
      yvalue=True

      q.append(root)
      print(q)
      while q:
        size1=len(q)
        xvalue=False
        yvalue=False
        print(q)
        for i in range(0,size1):
          h=q.popleft()
          if h.left and h.right and h.left.val==x and h.right.val==y:
            return False
          if h.left and h.right and h.left.val==y and h.right.val==x:
            return False
  
          if x==h.val:
            xvalue=True
          
          if y==h.val:
            yvalue=True
        
          if h.left:
            q.append(h.left)
          if h.right:
            q.append(h.right)
        
        if xvalue and yvalue:
          return True
        
        elif xvalue or yvalue:
          return False





        