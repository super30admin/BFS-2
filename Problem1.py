# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity --> O(n) where n is the number of nodes
# Space Complexity --> O(logn)
# Approach --> Doing DFS and at each level if the length of result is same as level, that would mean we are missing the value from current level. Also traverse through the right child followed by left child.
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.helper(root, 0)
        return self.result
    
    def helper(self, root, level):
        # base
        if root is None:
            return
        
        # logic
        if len(self.result)==level:
            self.result.append(root.val)
        self.helper(root.right, level+1)
        self.helper(root.left, level+1)
