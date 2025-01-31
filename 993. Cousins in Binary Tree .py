#space: O(n)
#Time: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        is_x = False
        is_y = False
        qu= list()
        qu.append(root)
        while (len(qu) != 0):
            for _ in range(len(qu)):
                node = qu.pop(0)
                if node.left is not None and node.right is not None:
                    if node.left.val ==x and node.right.val ==y:
                        return False
                    if node.left.val ==y and node.right.val ==x:
                        return False
                                       
                if node.left is not None:
                    qu.append(node.left)
                    if node.left.val ==x :
                        is_x = True
                    if node.left.val ==y:
                        is_y = True
                if node.right is not None:
                    qu.append(node.right)
                    if node.right.val ==x :
                        is_x = True
                    if node.right.val ==y:
                        is_y = True
            if is_x == True and is_y == True:
                return True
            elif is_x == True or is_y == True:
                return False
        return False
