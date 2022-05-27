# Time Complexity : O(N) where N is number of nodes in the tree
# Space Complexity : O(h) where h is height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None: return []
        result = []
        q = deque()
        
        q.append(root)
        
        while len(q) != 0:
            size = len(q)
            i = 0
            while i < size:
                node = q.pop()
                if node.left is not None:
                    q.appendleft(node.left)
                if node.right is not None:
                    q.appendleft(node.right)
                if i == size - 1:
                    result.append(node.val)
                i += 1
                
        return result