# Time Complexity:- O(n)
# Space Complexity:- O(h)
# Approach:- Do dfs and record the parent node and the depth of every node. If the parent node of x and y are not equal and the depth 
# are equal then they are cousins.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.x=[]
        self.y=[]
        def isc(root,parent,depth):
            if root is None:
                return
            if root.val==x:
                self.x=[parent,depth]
            if root.val==y:
                self.y=[parent,depth]
            isc(root.left,root.val,depth+1)
            isc(root.right,root.val,depth+1)
        isc(root,None,0)
        return self.x[0]!=self.y[0] and self.x[1]==self.y[1]
    
            