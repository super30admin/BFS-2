# TC: O(N)
# SC: O(N) - BFS
#     O(logN) - DFS

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
  res=[]
  def helper(self,root,level):
    if root == None:
      return 
    
    if len(self.res)<=level:
      self.res.append(root.val)
    
    self.res[level]=root.val

    if root.left:
      self.helper(root.left,level+1)

    if root.right:
      self.helper(root.right,level+1)

    
    

  def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
    self.res=[]
    self.helper(root,0)   
    print(self.res)
    return self.res


      # if root==None:
      #   return [] 
      # res=[]
      # q=deque()
      # q.append(root)
      # while q:
      #   size1=len(q)
      #   for i in range(0,size1):
      #     h=q.popleft()

      #     if i==size1-1:
      #       res.append(h.val)

      #     if h.left:
      #       q.append(h.left)
      #     if h.right:
      #       q.append(h.right)
      
      # return res

