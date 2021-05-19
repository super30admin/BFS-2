# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        '''
        TC : O(n) // traverse all the nodes
        SC : O(n) // for maintaing a queue
        
        Approach : 
        Apply level order traversal (BFS) and store the last element of all the levels. 
        
        '''
        if not root: return None
        q = [root]
        res = []
        while q:
            l = len(q)
            while l:
                x = q.pop(0)
                if x.left: q.append(x.left)
                if x.right: q.append(x.right)
                l -= 1
            res.append(x.val)
        return res