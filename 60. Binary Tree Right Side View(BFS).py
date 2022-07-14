# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        result = []
        q = [root]

        while q:
            size = len(q)
            for i in range(size):
                current = q.pop(0)
                if i == (size - 1):
                    result.append(current.val)
                if current.left:
                    q.append(current.left)
                if current.right:
                    q.append(current.right)

        return result


# Time Complexity = O(n).
# Space complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No