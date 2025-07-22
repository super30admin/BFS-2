# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n)
# Space Complexity: O(h)
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        if not root:
            return []

        def helper(root, level):
            if not root:
                return

            if level == len(self.result):
                self.result.append(root.val)

            helper(root.right, level + 1)
            helper(root.left, level + 1)

        helper(root, 0)
        return self.result