# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result=[]
        if not root:
            return []
        def helper(root,level):
            if root ==None:
                return 
            m=len(result)
            if m == level:
                result.append(root.val)
            else:
                result[level]=root.val
            helper(root.left,level+1)
            helper(root.right,level+1)
        helper(root,0)
        return result
       