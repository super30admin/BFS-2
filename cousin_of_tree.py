# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    xp=TreeNode()
    yp=TreeNode()
    xl=0
    yl=0
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None: return False
        self.helper (root, 0,None, x,y)
        #changed even the var names to self. types everywhere inside
        return self.xp!=self.yp and self.xl==self.yl
    def helper(self, root, level,parent, x,y):
        #base - when should it return from stack
        if root is None: return 
        #logic
        if root.val==x:
            self.xp=parent
            self.xl=level
        if root.val==y:
            self.yp= parent
            self.yl=level
        #when i didnt pass x,y to the dfs it wasnt recognising it
        #and it needed the parent too, we cant say put root as parent 
        #okay lets try -->update: that didnt work 
        self.helper(root.left, level+1, root, x,y) 
        self.helper(root.right, level+1,root, x,y)