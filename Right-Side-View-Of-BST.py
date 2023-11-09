# Time Complexity - O(N)
# Space Complexity - O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        
        queue = deque()
        queue.append([root, 0])

        result = []

        while queue:
            value, level = queue.popleft()

            if level == len(result):
                result.append(value.val)
            
            if value.right:
                queue.append([value.right, level+1])
            
            if value.left:
                queue.append([value.left, level+1])
        
        return result