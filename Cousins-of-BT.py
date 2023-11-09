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
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        level_map = dict()
        queue = deque()
        queue.append([root, 1, None])

        while queue:
            value, level, parent = queue.popleft()
            if value.val == x or value.val == y:
                if level in level_map:
                    level_map[level].append([value.val, parent.val])
                else:
                    level_map[level] = [[value.val, parent.val if parent != None else None]]
            
            if value.left:
                queue.append([value.left, level+1, value])
            if value.right:
                queue.append([value.right, level+1, value])

        print(level_map)
        if len(level_map.keys()) > 1:
            return False
        else:
            level = level_map.keys()
            for key in level:
                key = int(key)
            if level_map[key][0][1] != level_map[key][1][1]:
                return True
            return False
        