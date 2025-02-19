# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        queue = collections.deque()

        if not root:
            return []

        res = []
        queue.append([root])

        while queue:
            cur_level = queue.popleft()
            res.append(cur_level[-1].val)
            next_level = []
            for node in cur_level:
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            if len(next_level) > 0:
                queue.append(next_level)
        
        return res