# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        #Recursive
        def helper(root,level):
            if root==None:
                return
            
            if level==len(self.final):
                self.final.append(root.val)
            helper(root.right,level+1)
            helper(root.left,level+1)
        self.final=[]
        helper(root,0)
        return self.final
        # #Time O(n)
        # #Space O(n)
        
        
        #Iterative
        # queue=deque()
        # if root==None:
        #     return []
        # queue.append(root)
        # final=[]
        # while(len(queue)>0):
        #     s=len(queue)
        #     final.append(queue[-1].val)
        #     while(s>0):
        #         s-=1
        #         v=queue.popleft()
        #         if v.left:
        #             queue.append(v.left)
        #         if v.right:
        #             queue.append(v.right)
        # return final
        # #Time O(n)
        # #Space O(n)
            
