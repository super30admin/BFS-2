# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        #method1: use dfs to traverse the tree and keep track of the nodes at each level and update the latest

        res = []
        def dfs(root, d):
            nonlocal res 

            if not root:
                return
            
            if len(res)>d:
                res[d] = root.val
            else:
                res.append(root.val)
            
            dfs(root.left, d+1)
            dfs(root.right, d+1)
        
        dfs(root, 0)

        return res

        #time - O(n)
        #space - constant
            
