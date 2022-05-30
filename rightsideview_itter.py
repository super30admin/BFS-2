'''
time complexity: O(n)
space complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None: return []
        res = []
        
        q = deque([])
        
        q.append(root)
        
        while(len(q)!=0):
            n = len(q)
            res.append(q[n-1].val)
            for i in range(n):
                curr = q.popleft()
                if curr.left!=None: q.append(curr.left)
                if curr.right!=None: q.append(curr.right)
        return res