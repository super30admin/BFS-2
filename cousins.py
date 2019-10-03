# leetcode: accepted
# time complexity: O(n)
# explaination: for the trres to be cousins, you need to check if the are in the same level (depth ) and their paretns should not be the same. so you keep traversing level by level and compare the values of root with x and y. If you find x== x.val, you get the level and parent of it and check with Y's depth and parent.

# the depth should be same but parent should be different


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    xdep = -1
    ydep = -1
    xpar = None
    ypar = None

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:

        self.finddepthAndParent(root, 0, x, y, None)
        return self.xdep == self.ydep and self.xpar != self.ypar

    def finddepthAndParent(self, root, depth, x, y, parent):
        if root == None:
            return
        if root.val == x:  # checking the root value is equal to the x value
            self.xpar = parent
            self.xdep = depth
        if root.val == y:  # checking the root value is equal to the y value
            self.ypar = parent
            self.ydep = depth

        self.finddepthAndParent(root.left, depth + 1, x, y, root)  # iterating to left child
        self.finddepthAndParent(root.right, depth + 1, x, y, root)  # iterating to right child
        # print("parents",xpar,ypar)
        # print("levels",xdep,ydep)



