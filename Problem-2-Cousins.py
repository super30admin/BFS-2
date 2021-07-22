# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root, x, y) :
        if root is None or root.val == x or root.val == y:
            return False
        queue = []
        queue.append(root)

        xfound = False
        yfound = False

        while len(queue) != 0:

            size = len(queue)

            for i in range(size):

                curr = queue.pop(0)

                if curr.val == x:
                    xfound = True
                if curr.val == y:
                    yfound = True

                if curr.left is not None and curr.right is not None:
                    val1 = curr.left.val
                    val2 = curr.right.val

                    if (val1 == x and val2 == y) or (val2 == x and val1 == y):
                        return False
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            if xfound == True and yfound == True:
                return True
            if xfound == True or yfound == True:
                return False
        return False

