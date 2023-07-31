# Time Complexity: O(n)
# Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.dfs(root, 0, result)
        return result

    def dfs(self, root: Optional[TreeNode], level :int , result: List[int]):
        if root is None:
            return
        if level == len(result):
            result.append(root.val)
        else:
            result[level] = root.val
        self.dfs(root.left, level + 1, result)
        self.dfs(root.right, level + 1, result)
        



    
        
        

        