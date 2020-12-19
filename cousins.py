# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time: O(N)
# Space: O(N)
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        def isCousinsHelper(root, parent, parents, level, levels):
            if not root: return levels, parents

            if level == len(levels):
                levels.append([])
                parents.append([])

            levels[level].append(root.val)
            parents[level].append(parent.val)

            levels, parents = isCousinsHelper(root.left, root, parents, level + 1, levels)
            levels, parents = isCousinsHelper(root.right, root, parents, level + 1, levels)

            return levels, parents

        levels, parents = isCousinsHelper(root, TreeNode(float("inf")), [], 0, [])
        # print(levels)
        # print(parents)

        for level in range(1, len(levels)):
            current_level = levels[level]
            current_parent = parents[level]
            if x in current_level and y in current_level:
                idx_x = current_level.index(x)
                idx_y = current_level.index(y)
                parent_x = current_parent[idx_x]
                parent_y = current_parent[idx_y]
                if parent_x != parent_y:
                    return True
        return False