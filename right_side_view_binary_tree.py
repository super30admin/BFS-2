# Definition for a binary tree node.
# sc : O(N)
# TC: O(N)
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        q =[]
        q.append(root)
        
        while q:
            qlen = len(q)
            for i in range(qlen):
                node = q.pop(0)
                if node:
                    if i == qlen - 1 :
                        res.append(node.val)
                    #print(node.val)
                    if node.left:
                        q.append(node.left)
                    if node.right:
                        q.append(node.right)
        return res
                
        