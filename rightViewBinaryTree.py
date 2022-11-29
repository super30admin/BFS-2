# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Time Complexity -- > 

O(n)

Spacec Complexity -->

O(n) since we are using queue data structure
'''
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if root==None:
            return res
        q = [root]
        res.append(root.val)
        while q:
            l = len(q)
            #print(l)
            ls = []
            for i in range(l):
                s = q.pop(0)
                #print(s.val)
                if s.left:
                    q.append(s.left)
                    ls.append(s.left.val)
                if s.right:
                    q.append(s.right)
                    ls.append(s.right.val)
            #print(q)
            if len(ls)!=0:
                res.append(ls[-1])
        return(res)
                
        