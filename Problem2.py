'''
DFS:
1. We get the level of the node and the parent of the nodes whose values are x and y depth-wise. 
2. If the level of the nodes are equal and the parents are not equal, then we return True.
3. Else we return False.

TC: O(N)
SC: O(H) - Recursive stack 

BFS:
1. We traverse level by level and check if the current node's left and right child are equal to x and y. If yes then they aren't cousins.
2. If the current node's value is equal to x or y, then we set the respective flag to True.
3. If both the flags are True, then we return True. If only one of them is found, then we return False.

TC: O(N)
SC: O(N) - Diameter of the tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None:
            return False
        
        self.xParent = None
        self.yParent = None
        self.xlvl = -1
        self.ylvl = -1
        self.dfs(root,x,y,0,None)
        return self.xParent != self.yParent and self.xlvl == self.ylvl

    def dfs(self,root: Optional[TreeNode],x: int,y: int,lvl: int,parent: TreeNode) -> None:
        # Base 
        if root == None:
            return
        # Logic
        if root.val == x:
            self.xParent = parent
            self.xlvl = lvl
        elif root.val == y:
            self.yParent = parent
            self.ylvl = lvl
        self.dfs(root.left,x,y,lvl+1,root)
        self.dfs(root.right,x,y,lvl+1,root)

from queue import Queue
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None:
            return None
        q = Queue()
        xFound = False
        yFound = False
        q.put(root)

        #BFS
        while not q.empty():
            size = q.qsize()
            for _ in range(size):
                curr = q.get()
                if curr.left != None and curr.right != None:
                    if curr.left.val == x and curr.right.val == y or (curr.right.val == x and curr.left.val == y):
                        return False
                if curr.val == x:
                    xFound = True
                elif curr.val == y:
                    yFound = True
                if curr.left:
                    q.put(curr.left)
                if curr.right:
                    q.put(curr.right)
            if xFound and yFound:
                return True
            if xFound or yFound:
                return False
        return False