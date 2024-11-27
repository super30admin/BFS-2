# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        def helper(node, depth):
            if node is None:
                return
            
            if len(result) <= depth:
                result.append(node.val)
            
            helper(node.right, depth+1)
            helper(node.left, depth+1)

        helper(root, 0)
        return result
        
        