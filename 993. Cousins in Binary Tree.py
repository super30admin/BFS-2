# // Time Complexity : O(n)
# // Space Complexity : DFS-O(h) BFS O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach


# DFS approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.xParent = None
        self.yParent = None
        self.xDepth = 0
        self.yDepth = 0
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root == None:
            return False
        self.dfs(root,None,0,x,y)
        return (self.xParent != self.yParent and self.xDepth == self.yDepth)
    
    def dfs(self,Node,PNode,Depth,x,y):
        if Node == None:
            return
        if Node.val == x:
            self.xParent = PNode
            self.xDepth = Depth
        if Node.val == y:
            self.yParent = PNode
            self.yDepth = Depth
        
        self.dfs(Node.left,Node,Depth + 1,x ,y)
        self.dfs(Node.right,Node,Depth + 1,x ,y)
		
#BFS Approach:
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        Queue = deque()
        Queue.append(root)
        while Queue:
            size = len(Queue)
            xFound = False
            yFound = False
            for i in range(size):
                currNode = Queue.popleft()
                if currNode.val == x: xFound = True
                if currNode.val == y: yFound = True
                    
                if currNode.left != None and  currNode.right != None:
                    if currNode.left.val == x and currNode.right.val == y: return False
                    if currNode.left.val == y and currNode.right.val == x: return False
                
                if  currNode.left != None: Queue.append(currNode.left)
                if  currNode.right != None: Queue.append(currNode.right)
            if xFound and yFound:
                return True
            if xFound or yFound:
                return False
        return False