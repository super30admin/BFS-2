# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        if root==None:
            return result
        
        q=[root]
        while q:
            qlen=len(q)
            for i in range(qlen):
                node=q.pop(0)
                #If it is the last element add it to the array
                if i==qlen-1:
                    result.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return result