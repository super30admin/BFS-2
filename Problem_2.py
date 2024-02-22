#
# @lc app=leetcode id=993 lang=python3
#
# [993] Cousins in Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time Complexity - O(n). We are traversing both the nodes in any case, be it BFS or DFS
Space Complexity - O(n) for BFS, O(h) for DFS

This code works on leetcode
'''
from collections import deque
class Solution:
    def __init__(self):
        self.x_parent = TreeNode()
        self.y_parent = TreeNode()
        self.x_depth = -1
        self.y_depth = -1
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None: #empty tree
            return False
        xPar = None
        yPar = None
        foundx, foundy = False, False
        nodeQ = deque()
        nodeQ.append((root, None)) #add root with parent as null to queue
        while nodeQ:
            for i in range(len(nodeQ)): #we are going level by level
                npPair = nodeQ.popleft() #take out the child with parent from queue
                child = npPair[0] #1st in tuple is child
                parent = npPair[1] #2nd in tuple is the parent
                if child.val == x: #if child is x
                    xPar = parent #store parent and mark found as True
                    foundx = True
                if child .val == y: #store parent and mark found as True
                    yPar = parent
                    foundy = True
                if child.left != None: #add to queue if left child is present
                    nodeQ.append((child.left, child))
                if child.right != None: #add to queue if right child is present
                    nodeQ.append((child.right, child))
            
            if (foundx and foundy) and  (xPar != yPar): #x and y are cousins as both were found at same level and have different parents
                return True
            if (foundx and foundy) and  (xPar == yPar): #x and y are not cousins as even though both were found at same level but have same parent
                return False
            if foundx or foundy: #Either x was found or y was found
                return False
        return False #return False if neither x nor y was found



        # self.dfs(root, None, 0, x, y)
        # if (self.x_depth == self.y_depth) and (self.x_parent!=self.y_parent): #if both x and y have different parents and are at same level return True as they are cousins.
        #     return True 
        # else: #otherwise return False
        #     return False
    def dfs(self, root, parent, depth, x, y):
        if root == None: #stop recursion as we reached a leaf node
            return 
        if root.val == x: #store depth and parent if x is found
            self.x_depth = depth
            self.x_parent = parent
        if root.val == y: #store depth and parent if y is found
            self.y_depth = depth
            self.y_parent = parent
        if self.x_depth == -1 or self.y_depth == -1: 
            self.dfs(root.left, root, depth + 1, x, y) #go left to next level, keep track of parent
        if self.x_depth == -1 or self.y_depth == -1:
            self.dfs(root.right, root, depth + 1, x, y) #go right to next level, keep track of parent
        
# @lc code=end

