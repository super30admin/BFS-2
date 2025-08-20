# Binary Tree Right Side View

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# DFS using post order traversal 
# For each level, we get the rightmost node first and add it to the result if it's the first node that was identified in that level.

from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.res = []
        def helper(root, height):
            if not root:
                return []
            if height == len(self.res):
                self.res.append(root.val)
            helper(root.right, 1+height)
            helper(root.left,1+height)
            return self.res
        return helper(root,0)

# BFS
# This approach uses a queue to traverse the tree level by level, ensuring that the rightmost node at each level is added to the result list.
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        self.res = []
        queue = deque([root])
        while queue:
            for i in range(len(queue)):
                node = queue.popleft()
                if i==0:
                    self.res.append(node.val)
                
                if node.right:
                    queue.append(node.right)
                if node.left:
                    queue.append(node.left)

        return self.res

        