# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time: O(N)
# Space: O(N)
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        def rightSideViewHelper(root, level, levels):
            if not root: return levels
            if level == len(levels):
                levels.append([])

            levels[level].append(root.val)
            levels = rightSideViewHelper(root.left, level + 1, levels)
            levels = rightSideViewHelper(root.right, level + 1, levels)

            return levels

        levels = rightSideViewHelper(root, 0, [])
        # print(levels)

        right_view = []
        for level in range(len(levels)):
            right_view.append(levels[level][-1])
        # print(right_view)

        return right_view