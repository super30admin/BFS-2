'''
Solution:
1.  The problem can be solved using one of the 3 methods (BFS using Queue or DFS using Stack or DFS using Recursion).
    In each of the solutions, maintain two flags to check whether x is found and y is found or not.
2.  In BFS using Queue,  check whether both x and y are children of the same parent, also check whether they are from
    from the same level or not using size variable and return true if everything is accordingly found.
3.  In DFS approaches, pass the level and also the parent node as parameters to the function calls (recursive stack) or
    push to the stack and return true if everything is accordingly found.

--- Passed all testcases on Leetcode successfully for all three solutions.

Time Complexity: O(n) in all 3 solutions, where n is the number of employees
Space Complexity: O(n) in BFS using Queue and O(h) in DFS approaches
'''


from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Cousins_Queue(object):

    def __areChildrenXandY(self, root, x, y):

        #   function to check whether both are children of same parent

        if (root == None):
            return False

        if (root.left != None and root.right != None):
            if ((root.left.val == x and root.right.val == y) or
                    (root.left.val == y and root.right.val == x)):
                return True

        return False

    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        #   edge case check
        if (root == None):
            return False

        #   boolean variables to keep track of whether x and y are found
        x_found = False; y_found = False

        #   initialize the queue
        queue = deque([root])

        while (len(queue) > 0):
            #   maintain size variable to keep track of the level
            size = len(queue)

            for i in range(size):

                node = queue.popleft()

                #   check whether the current node's children are x and y
                if (self.__areChildrenXandY(node, x, y)):   return False

                #   check for updating the boolean variables x and y found
                if (node.val == x):     x_found = True
                if (node.val == y):     y_found = True

                #   append to the queue corresponding elements
                if (node.left != None):     queue.append(node.left)
                if (node.right != None):    queue.append(node.right)

            #   return true if everything is accordingly found.
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

        #   check for updating the boolean variables x and y found, along with their parents and levels
        if (root.val == x):
            self.x_found = True
            self.x_parent = parent
            self.x_level = level

        if (root.val == y):
            self.y_found = True
            self.y_parent = parent
            self.y_level = level

        #   recursion call on left and right nodes by updating the level and parent nodes
        self.__isCousinsHelper(root.left, x, y, level + 1, root)
        self.__isCousinsHelper(root.right, x, y, level + 1, root)

    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        #   main function call
        self.__isCousinsHelper(root, x, y, 0, None)

        #   return true if everything is accordingly found.
        if (self.x_found and self.y_found):
            if (self.x_parent != self.y_parent and self.x_level == self.y_level):
                return True

        return False


class Cousins_Stack(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        #   edge case check
        if (root == None):  return False

        #   initializations
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

                #   check for updating the boolean variables x and y found, along with their parents and levels
                if (currentNode.val == x):
                    x_found = True; x_parent = currentParent; x_level = currentLevel

                if (currentNode.val == y):
                    y_found = True; y_parent = currentParent; y_level = currentLevel

                #   push left element if exists, by updating the level and parent nodes
                if (currentNode.left != None):
                    stack.append([currentNode.left, currentLevel + 1, 0, currentNode])

            elif (currentCount == 1):

                stack[-1][2] += 1

                #   push right element if exists, by updating the level and parent nodes
                if (currentNode.right != None):
                    stack.append([currentNode.right, currentLevel + 1, 0, currentNode])

            #   pop the actual element if both children are processed
            elif (currentCount == 2):
                stack.pop()

        #   return true if everything is accordingly found.
        if (x_found and y_found):
            if (x_parent != y_parent and x_level == y_level):
                return True

        return False