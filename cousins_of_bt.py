# O(N) TIME AND O(D) SPACE WHERE N IS NO.OF NODES AND D IS DIAMETER
from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root is None:
            return False
        que = deque()
        que.append((root,-1))
        x_parent = None
        y_parent = None
        while que:
            size = len(que)
            for _ in range(size):
                node,parent = que.popleft()
                if node.val == x:
                    x_parent = parent
                elif node.val == y:
                    y_parent = parent
                if node.left is not None:
                    que.append((node.left,node.val))
                if node.right is not None:
                    que.append((node.right,node.val))
                    
            if x_parent != None and y_parent != None and x_parent != y_parent:
                return True 
            elif (x_parent == None and y_parent != None) or (y_parent == None and x_parent != None):
                return False
        return False