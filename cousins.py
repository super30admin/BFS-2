# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Time complexity - O(n)
# Space complexity - O(n)
# Did this solution run on leetcode? - yes
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.parX = -1
        self.depthX = -1
        self.parY = -1
        self.depthY = -1
        
        def rec(node, prev, depth):
            # logic
            if node:
                if node.val == x:
                    self.parX = prev
                    self.depthX = depth
                elif node.val == y:
                    self.parY = prev
                    self.depthY = depth
                rec(node.left, node, depth+1)
                rec(node.right, node, depth+1)
            
        rec(root, None, 0)
        return (self.depthX == self.depthY) and (self.parX != self.parY)
   
    
# Breadth first search 
# Time complexity - O(n)
# Space complexity - O(n)
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        lvl = 0
        nodeStack = deque()
        nodeStack.append(root)
        nodeStack.append(None)
        
        while nodeStack:
            for i in range(len(nodeStack)//2):
                node = nodeStack.popleft()   # pop the parent node which is on the top of the stack
                par = nodeStack.popleft()  # pop the current node 
                if node.val == x:   
                    parX = par          # set the parent and the level of X and Y
                    lvlX = lvl
                elif node.val == y:
                    parY = par
                    lvlY = lvl
                if node.left:           # append the left child or right child, and current node to the stack. 
                    nodeStack.append(node.left)
                    nodeStack.append(node)
                if node.right:
                    nodeStack.append(node.right)
                    nodeStack.append(node)
            lvl+=1
        
        return (parX!=parY) and (lvlX==lvlY)
              
        
# Leetcode solution using DFS
# Time complexity - O(n)
# Space complexity - O(n)
# Did this solution run on leetcode? - yes
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.isCousin = False
        self.depth = None
        
        def rec(node, depth):
            if not node or (self.depth and depth > self.depth): # stop traversing further if the depth is greater than the recorded depth.
                return False
            elif node.val == x or node.val == y:
                if self.depth is None:
                    self.depth = depth
                # return True, if the depth is the same as the recorded depth (always returns True for one child as the recorded depth is the same as the current depth.)
                return self.depth==depth 
            
            # traverse to the left and right subtree.
            left = rec(node.left, depth+1)
            right = rec(node.right, depth+1)
            
            # since now we are at the previous level so we want to make sure that the recorded depth is not the same as depth + 1. Makes sure that both x and y should not be the children for the current parent node.
            if left and right and self.depth != depth+1: 
                self.isCousin = True
                
            return left or right
        
        rec(root, 0)
        return self.isCousin