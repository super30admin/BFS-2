# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time complexity -> O(n)
# Space complexity -> O(n)

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root:
            return res
        
        stack = [root]
        
        while stack:
            l = len(stack)
            
            for i in range(l):
                temp = stack.pop(0)
                if temp.left:
                    stack += [temp.left]

                if temp.right:
                    stack += [temp.right]
                    
                if i == l-1:
                    res += [temp.val]
                    
        return res
    
    
#     res = []
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         if not root:
#             return self.res
        
#         self.helper(root,0)
#         return self.res
        
#     def helper(self,root, level):
#         if not root:
#             return
        
#         if len(self.res) == level:
#             self.res += [root.val]
        
#         self.helper(root.right,level+1)
#         self.helper(root.left,level+1)
            
            
            