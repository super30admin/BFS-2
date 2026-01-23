"""
time = o(n)
space - 0(n) (recursion stack)
we recursively visit every node of tree and check if at each level there is a value in the result array at that index (where level is the index)
if an index = level of the tree is not in result array we just add the right most side of that level into the array, we do this by visiting right side first and then left
"""
from typing import Optional, List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.helper(root, 0, result)
        return result
    
    def helper(self, root, level, result):
        if not root:
            return
        if len(result)==level:
            result.append(root.val)
        self.helper(root.right, level+1, result)
        self.helper(root.left, level+1, result)
    
