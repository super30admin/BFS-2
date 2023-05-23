#TC: O(n)
#SC: O(n)

from collections import deque

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def __areChildrenXandY(self, root, x, y):

        if (root == None):
            return False

        if (root.left != None and root.right != None):
            if ((root.left.val == x and root.right.val == y) or
                    (root.left.val == y and root.right.val == x)):
                return True

        return False

    def isCousins(self, root, x, y):
        
        if (root == None):
            return False

        x_found = False; y_found = False

        queue = deque([root])

        while (len(queue) > 0):
            size = len(queue)

            for i in range(size):

                node = queue.popleft()

                if (self.__areChildrenXandY(node, x, y)):   return False

                if (node.val == x):     x_found = True
                if (node.val == y):     y_found = True

                if (node.left != None):     queue.append(node.left)
                if (node.right != None):    queue.append(node.right)

            if (x_found and y_found):   return True
            if (x_found or y_found):    return False

        return False


class Cousins_Recursion(object):

    def __init__(self):

        self.x_found = False; self.y_found = False
        self.x_parent = None; self.y_parent = None
        self.x_level = -1; self.y_level = -1

    def __isCousinsHelper(self, root, x, y, level, parent):

        if (root == None):
            return

        if (root.val == x):
            self.x_found = True
            self.x_parent = parent
            self.x_level = level

        if (root.val == y):
            self.y_found = True
            self.y_parent = parent
            self.y_level = level

        self.__isCousinsHelper(root.left, x, y, level + 1, root)
        self.__isCousinsHelper(root.right, x, y, level + 1, root)

    def isCousins(self, root, x, y):
    
        self.__isCousinsHelper(root, x, y, 0, None)

        if (self.x_found and self.y_found):
            if (self.x_parent != self.y_parent and self.x_level == self.y_level):
                return True

        return False


class Cousins_Stack(object):
    def isCousins(self, root, x, y):
        
        if (root == None):  return False

        stack = deque([[root, 0, 0, None]])

        x_found = False; y_found = False
        x_parent = None; y_parent = None
        x_level = -1; y_level = -1

        while (len(stack) > 0):

            currentNode = stack[-1][0]
            currentLevel = stack[-1][1]
            currentCount = stack[-1][2]
            currentParent = stack[-1][3]

            if (currentCount == 0):

                stack[-1][2] += 1

          
                if (currentNode.val == x):
                    x_found = True; x_parent = currentParent; x_level = currentLevel

                if (currentNode.val == y):
                    y_found = True; y_parent = currentParent; y_level = currentLevel

                if (currentNode.left != None):
                    stack.append([currentNode.left, currentLevel + 1, 0, currentNode])

            elif (currentCount == 1):

                stack[-1][2] += 1

                if (currentNode.right != None):
                    stack.append([currentNode.right, currentLevel + 1, 0, currentNode])

            elif (currentCount == 2):
                stack.pop()

        if (x_found and y_found):
            if (x_parent != y_parent and x_level == y_level):
                return True

        return False