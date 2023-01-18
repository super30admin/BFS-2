# Time Complexity :O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.parentx=0
        self.parenty=0
        self.levelx=0
        self.levely=0
    def bfs(self,root, level,parent,x,y):
            if root is None:
                return 
            self.bfs(root.left,level+1,root,x,y)
            self.bfs(root.right,level+1,root,x,y)
            
            if(root.val==x):
                self.parentx=parent
                self.levelx=level

            elif(root.val ==y):
                self.parenty=parent
                self.levely=level
    def isCousins(self, root, x, y):
        self.bfs(root, 0,None,x,y)
        if(self.parentx==self.parenty):
            return False
        if(self.levelx==self.levely):
            return True