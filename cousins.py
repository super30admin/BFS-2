# leetcode: not accepted
# 81/103 cases passed
# time complexity: O(n)
# explaination: for the trres to be cousins, you need to check if the are in the same level (depth ) and their paretns should not be the same. so you keep traversing level by level and compare the values of root with x and y. If you find x== x.val, you get the level and parent of it and check with Y's depth and parent


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        xdep = -1
        ydep = -1
        xpar = None
        ypar = None
        # xpar=TreeNode(None)
        # ypar=TreeNode(None)
        self.finddepthAndParent(root, 0, x, y, None)

        return xdep == ydep and xpar != ypar

    def finddepthAndParent(self, root, depth, x, y, parent):
        if root == None:
            return
        if root.val == x:
            xpar = parent
            xdep = depth
        if root.val == y:
            ypar = parent
            ydep = depth

        self.finddepthAndParent(root.left, depth + 1, x, y, root)
        self.finddepthAndParent(root.right, depth + 1, x, y, root)
        # print("parents",xpar,ypar)
        # print("levels",xdep,ydep)