#Time Complexity O(n)
#Space Complexity O(h) (for balanced tree) O(n) (for unbalanced/skewed tree)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        def dfs(root, level, result):
            if root == None: return result

            if level == len(result):
                result.append(root.val)
            dfs(root.right, level+1, result)
            dfs(root.left, level+1, result)
        dfs(root, 0, result)
        return result
