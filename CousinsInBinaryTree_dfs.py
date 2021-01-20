#time= O(n)
#space= O(h)
#leetcode=yes 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    x_parent=None
    x_level=0
    y_parent=None
    y_level=0
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if(root==None):
            return None
        self.helper(root,x,y,None,0)
        return (self.x_level==self.y_level and self.x_parent!=self.y_parent)
    def helper(self,root,x,y,parent,level):
        if(root==None):
            return 
        if(x==root.val):
            self.x_parent=parent
            self.x_level=level
        if(y==root.val):
            self.y_parent=parent
            self.y_level=level
        self.helper(root.left,x,y,root,level+1)
        self.helper(root.right,x,y,root,level+1)
            
            
            
            
    