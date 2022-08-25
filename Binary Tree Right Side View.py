# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        if root is None:
            return None
        q = []
        res = []
        q.append(root)
        while len(q) != 0:
            length = len(q)
            for i in range(length):
                temp = q.pop(0)
                inter = temp.val
                if temp.left:
                    q.append(temp.left)
                if temp.right:
                    q.append(temp.right)
            
            res.append(inter)
        
        return res