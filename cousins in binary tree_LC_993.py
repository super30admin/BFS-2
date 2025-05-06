# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # if not root:
        #     return True
        # level = 0
        # que = [(root, root, 0)]

        # while que:
        #     size = len(que)
        #     level = level + 1
        #     for i in range(size):
        #         parent, curr, currlvl = que.pop(0)
        #         if curr.val == x:
        #             xLvl = currlvl
        #             xParent = parent.val
        #         elif curr.val == y:
        #             yLvl = currlvl
        #             yParent = parent.val
        #         if curr.left:
        #             que.append((curr, curr.left, level))
        #         if curr.right:
        #             que.append((curr, curr.right, level))
       
        # if xParent != yParent:
        #     return xLvl == yLvl
        # return False

        if not root:
            return True

        self.x_lvl = 0
        self.y_lvl = 0
        self.x_parent = None
        self.y_parent = None
        self.recurse(root, x, y, 0, None)

        return self.x_parent != self.y_parent and self.x_lvl == self.y_lvl

    def recurse(self, root, x, y, level, parent):
        if not root:
            return
        
        if root.val == x:
            self.x_lvl = level
            self.x_parent = parent
        if root.val == y:
            self.y_lvl = level
            self.y_parent = parent

        self.recurse(root.left, x, y, level + 1, root)
        self.recurse(root.right, x, y, level + 1, root)
