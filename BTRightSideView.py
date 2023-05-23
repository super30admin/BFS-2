#TC: O(n)
#SC: O(n)

from collections import deque

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def rightSideView(self, root):
        
        if (root == None):
            return []

        finalList = []
        queue = deque([root])               

        while (len(queue) > 0):

            size = len(queue)
            node = None

            for i in range(size):

                node = queue.popleft()

                if (node.left != None):
                    queue.append(node.left)
                if (node.right != None):
                    queue.append(node.right)

            finalList.append(node.val)

        return finalList


class RightSideView_Queue_Right(object):
    def rightSideView(self, root):
        
        if (root == None):
            return []

        finalList = []
        queue = deque([root])                  

        while (len(queue) > 0):

            size = len(queue)
            node = queue.popleft()
            finalList.append(node.val)

            for i in range(size - 1):

                if (node.right != None):
                    queue.append(node.right)

                if (node.left != None):
                    queue.append(node.left)

                node = queue.popleft()

            if (node.right != None):
                queue.append(node.right)

            if (node.left != None):
                queue.append(node.left)

        return finalList


class RightSideView_Recursion_Left(object):

    def __init__(self):
        self.finalList = []

    def __rightSideViewHelper(self, root, level):
        
        if (root == None):
            return

        if (level == len(self.finalList)):
            self.finalList.append(root.val)
        elif (level < self.finalList):
            self.finalList[level] = root.val

        self.__rightSideViewHelper(root.left, level + 1)
        self.__rightSideViewHelper(root.right, level + 1)

    def rightSideView(self, root):
        
        self.__rightSideViewHelper(root, 0)
        return self.finalList


class RightSideView_Recursion_Right(object):

    def __init__(self):
        self.finalList = []

    def __rightSideViewHelper(self, root, level):
        #   base case
        if (root == None):
            return

        if (level == len(self.finalList)):
            self.finalList.append(root.val)

        self.__rightSideViewHelper(root.right, level + 1)
        self.__rightSideViewHelper(root.left, level + 1)

    def rightSideView(self, root):
        
        self.__rightSideViewHelper(root, 0)
        return self.finalList


class RightSideView_Stack_Left(object):
    def rightSideView(self, root):
        
        if (root == None):
            return []

        finalList = []

        stack = deque([[root, 0, 0]])

        while (len(stack) > 0):

            currentNode = stack[-1][0]    
            currentLevel = stack[-1][1]     
            currentCount = stack[-1][2]    

            if (currentCount == 0):

                stack[-1][2] += 1

                if (currentLevel == len(finalList)):        
                    finalList.append(currentNode.val)
                else:
                    finalList[currentLevel] = currentNode.val  

                if (currentNode.left != None):
                    stack.append([currentNode.left, currentLevel + 1, 0])   

            elif (currentCount == 1):

                stack[-1][2] += 1

                if (currentNode.right != None):
                    stack.append([currentNode.right, currentLevel + 1, 0])  

            elif (currentCount == 2):

                stack.pop()

        return finalList


class RightSideView_Stack_Right(object):
    def rightSideView(self, root):
        
        if (root == None):
            return []

        finalList = []

        stack = deque([[root, 0, 0]])

        while (len(stack) > 0):

            currentNode = stack[-1][0]       
            currentLevel = stack[-1][1]       
            currentCount = stack[-1][2]   

            if (currentCount == 0):

                stack[-1][2] += 1

                if (currentLevel == len(finalList)): 
                    finalList.append(currentNode.val)

                if (currentNode.right != None):
                    stack.append([currentNode.right, currentLevel + 1, 0])    

            elif (currentCount == 1):

                stack[-1][2] += 1

                if (currentNode.left != None):
                    stack.append([currentNode.left, currentLevel + 1, 0])   

            elif (currentCount == 2):

                stack.pop()

        return finalList