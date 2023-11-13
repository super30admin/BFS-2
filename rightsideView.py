# Time Complexity: O(n) : n is the number of nodes in the tree
# Space Complexity: O(h) : H is the height of the Tree

# Because we process the left node before the right node, the right node is always the last to be processed.
# As the DFS proceeds, for a given level, the right-most node of the level is processed at the last, 
# So we append/overwrite the value in the Result List.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root: Optional[TreeNode], level: int) -> None:

        if root is None:
            return
        
        if len(self.result) == level:
            self.result.append(-101)
        
        if self.result[level]:
            self.result[level] = root.val
        
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)


        