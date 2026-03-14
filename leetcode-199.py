# 199. Binary Tree Right Side View
#  https://leetcode.com/problems/binary-tree-right-side-view/

#  T.C:O(n) 
#  S.C:O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        if not root:
            return []

        q = deque()
        q.append(root)
        res = []


        while q:
            size = len(q)
            curr = None
            for i in range(size):
                curr = q.popleft()
                if curr.left:
                    q.append(curr.left)
                
                if curr.right:
                    q.append(curr.right)
            
            if curr:
                res.append(curr.val)
        
        return res