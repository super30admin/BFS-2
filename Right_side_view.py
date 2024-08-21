# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        ds=[]

        def dfs(root,level):
            if not root:
                return
            if level==len(ds):
                ds.append(root.val)
            
            dfs(root.right,level+1)
            dfs(root.left,level+1)

        dfs(root,0)

        return ds

        #TC->O(N)
        #SC->O(H)