#TIme Complexity =O(n)
#Space Complexity = O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if(root==None):
            return None
        result = []
        self.helper(root,result,0)
        return result
    def helper(self,root,result,depth):
        if(root==None):
            return None
        if(depth ==len(result)):
            result.append(root.val)
        self.helper(root.right,result,depth+1)
        self.helper(root.left,result,depth+1)
        