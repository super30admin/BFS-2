# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# time complexity: O(n)
# space complexity: O(n)

from queue import Queue
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result=[]
        if root==None: return self.result
        
        def dfs(root, lvl):
            #base
            if root==None:
                return
            #logic
            if len(self.result)==lvl:
                self.result.append(root.val)
            
            dfs(root.right, lvl+1)
            dfs(root.left, lvl+1)
                
        dfs(root, 0)
        return self.result
        
#         q=Queue()
        
#         q.put(root)
#         while not q.empty():
#             size=q.qsize()
#             for i in range(size):
#                 curr=q.get()
#                 if i==size-1:
#                     result.append(curr.val)
                    
#                 if curr.left!=None:
#                     q.put(curr.left)
#                 if curr.right!=None:
#                     q.put(curr.right)
                    
#         return result