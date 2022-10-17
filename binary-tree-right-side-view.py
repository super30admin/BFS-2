# Time complexity: O(n)
# Space complexity: O(n)

# Code succcessfully ran on Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root == None:    return result
        
        result.append(root.val)
        q = []
        q.append(root)
        size = 1
        
        while q:            
            for i in range(size):
                curr = q.pop(0)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            if q:    
                size = len(q)
                result.append(q[size - 1].val)
            
        return result
            
        
        
        