# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(N)
# Space Complexity: O(N)
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        mp = []

        def dfs(node, level): 
            nonlocal mp
            if not node: return 

            if len(mp) == level: 
                mp.append(node.val)
            else:
                mp[level] = node.val
                
            dfs(node.left, level+1)
            dfs(node.right, level+1)

        dfs(root, 0)
        return mp
