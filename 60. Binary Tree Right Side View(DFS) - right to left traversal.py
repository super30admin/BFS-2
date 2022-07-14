# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        def dfs(root, level):
            if not root:
                return

            if len(self.result) <= level:
                self.result.append(root.val)
            # else:
            #     self.result[level] = root.val

            # dfs(root.left, level + 1)
            dfs(root.right, level + 1)
            dfs(root.left, level + 1)

        self.result = []
        dfs(root, 0)

        return self.result

# right to left traversal


# Time Complexity = O(n).
# Space complexity : O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
