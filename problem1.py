'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation:
Go through the tree (recursive or iterative) and get the parentX and parentY value and also the levels if parentX and parentY
not equal and if the levels are same then return True
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.levelX = -1
        self.levelY = -1

        self.parentY = -1
        self.parentX = -1

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:

        if root == x or root == y:
            return False

        self.dfs(root, x, y, 0)

        return self.parentX != self.parentY and self.levelX == self.levelY

    def dfs(self, current: TreeNode, x: int, y: int, level: int) -> bool:
        if current == None:
            return False

        if current.left != None:
            if current.left.val == x:
                self.parentX = current.val
                self.levelX = level
            elif current.left.val == y:
                self.parentY = current.val
                self.levelY = level
            self.dfs(current.left, x, y, level + 1)

        if current.right != None:
            if current.right.val == x:
                self.parentX = current.val
                self.levelX = level
            elif current.right.val == y:
                self.parentY = current.val
                self.levelY = level
            self.dfs(current.right, x, y, level + 1)

    def isCousinsIterative(self, root: TreeNode, x: int, y: int) -> bool:
        if root == None:
            return False

        if root == x or root == y:
            return False

        queue = [root]
        levelX = -1
        levelY = -1
        parentY = parentX = -1
        level = 0
        while (len(queue) != 0):
            numberofElements = len(queue)

            for i in range(0, len(queue)):
                current = queue[0]
                queue = queue[1:]

                if current.left != None:
                    if current.left.val == x:
                        parentX = current.val
                        levelX = level
                    elif current.left.val == y:
                        parentY = current.val
                        levelY = level
                    queue.append(current.left)
                if current.right != None:
                    if current.right.val == x:
                        parentX = current.val
                        levelX = level
                    elif current.right.val == y:
                        parentY = current.val
                        levelY = level
                    queue.append(current.right)

            level += 1

        return parentX != parentY and levelX == levelY


