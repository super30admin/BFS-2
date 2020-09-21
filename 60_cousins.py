# S30 Big N Problem #60 {Easy}

# LC - 993. 
# Cousins in Binary Tree

# Time Complexity : O(n) n=no. of nodes in the tree
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach 
# Traverse the tree and maintain the level of the node. 
# when the x or y node is encountered, stored the parent and the level of the node 
# at the end, compare the depth and the parent and send the result accordingly. 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    depthx=-1
    depthy=-1
    parentx=None
    parenty=None
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        if root is None:
            return False
        
        self.helper(root,x,y,0)
        
        if self.depthx==self.depthy and self.parentx!=self.parenty:
            return True
        else:
            return False
            
        
    def helper(self,root,x,y,depth):
        
        if root is None:
            return 
        
        if root.val==x:
            self.depthx=depth
        
        if root.val==y:
            self.depthy=depth
            
        if root.left!=None and root.left.val==x:
            self.parentx=root
        if root.right!=None and root.right.val==x:
            self.parentx=root
            
        if root.left!=None and root.left.val==y:
            self.parenty=root
        if root.right!=None and root.right.val==y:
            self.parenty=root
            
        self.helper(root.left,x,y,depth+1)
        self.helper(root.right,x,y,depth+1)
        
        
        
        
            
            
            
        
        
        