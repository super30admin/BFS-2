# O(N) TIME AND O(D) SPACE WHERE N IS NO.OF NODES AND D IS DEPTH OF BT
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.x_depth = 0
        self.y_depth = 0
        self.x_parent = None
        self.y_parent = None
        self.isCousinsHelper(root,None,0,x,y)
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent

    
    def isCousinsHelper(self,node,parent,depth,x,y):
        if node is None:
            return
        if node.val == x:
            self.x_depth = depth + 1
            self.x_parent = parent
        if node.val == y:
            self.y_depth = depth + 1
            self.y_parent = parent
        
        self.isCousinsHelper(node.left,node.val,depth+1,x,y)        
        self.isCousinsHelper(node.right,node.val,depth+1,x,y)        
        