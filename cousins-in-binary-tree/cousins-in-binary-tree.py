# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity: O(n)
# space complexity: o(D)(Diameter of tree)
from collections import deque
class Solution:
    def __init__(self):
        compare = []
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return None
        queue = deque()
        queue.append(root)
        levelx = 0
        levely = 0
        level = -1
        root.val = [root.val,root.val]
        x_rootnode = root.val
        y_rootnode = root.val
        while queue:          
            order = len(queue)
            for i in range(order):
                node = queue.popleft()
                root_node = node.val
                if node.val[0] == x:
                    levelx = level
                    x_rootnode = node.val
                elif node.val[0] == y:
                    levely = level
                    y_rootnode = node.val
                if node.left:
                    node.left.val = [node.left.val, node.val[0]]
                    queue.append(node.left)
                if node.right:
                    node.right.val = [node.right.val, node.val[0]]
                    queue.append(node.right)
            level = level + 1
        print(levelx,levely)
        if levelx == levely and x_rootnode[1] != y_rootnode[1]:
            return True
        else:
            return False
