# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

TC: O(n)
SC: O(n)

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return False

        queue = []

        queue.append(root)
        XBool = False
        YBool = False
        while queue:
            size = len(queue)
            for i in range(size):
                el = queue.pop(0)

                if el.val == x:
                    XBool = True

                if el.val == y:
                    YBool = True

                if el.left is not None and el.right is not None and el.left.val == x and el.right.val == y:
                    return False

                if el.left is not None and el.right is not None and el.left.val == y and el.right.val == x:
                    return False

                if el.left is not None:
                    queue.append(el.left)

                if el.right is not None:
                    queue.append(el.right)

            if XBool == False and YBool == False:
                continue
            elif XBool == True and YBool == True:
                return True
            else:
                return False

        return False
