# problem 1 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.final_arr = []
        self.helper(root,0)
        return self.final_arr 

    def helper(self,root,depth):
        if not root:
            return 
        if len(self.final_arr) == depth:
            self.final_arr.append(float('-inf')) # 
        self.helper(root.left,depth+1)
        self.final_arr[depth] = root.val
        self.helper(root.right,depth+1)