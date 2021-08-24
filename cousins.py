"""
//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        if root is None:
            return False
        from collections import deque
        q=deque()
        q.append(root)
        while(len(q)>0):
            x_found = False
            y_found = False
            size = len(q)
            for i in range(0,size):
                node = q.popleft()
                if(node.val == x):
                    x_found = True
                if(node.val == y):
                    y_found = True
                if (node.left!=None and node.right!=None):
                    if node.left.val == x and node.right.val == y:
                        return False
                    if node.left.val == y and node.right.val == x:
                        return False
                if node.left!=None:
                    q.append(node.left)
                if node.right!=None:
                    q.append(node.right)
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
        return False
            
        
#         #T.C = O(n)
#         #s.C = O(h)
#         self.x_parent = None
#         self.y_parent = None
#         self.x_depth = 0
#         self.y_depth = 0
        
#         if root ==None:
            
#             return False
#         self.dfs(root,x,y,0,None)
#         return (self.x_depth == self.y_depth) and (self.x_parent!=self.y_parent)
#     def dfs(self,root,x,y,depth,parent):
#         if root is None:
#             return False
#         if(x == root.val):
#             self.x_parent = parent
#             self.x_depth = depth
#         if(y == root.val):
#             self.y_parent = parent
#             self.y_depth = depth
#         self.dfs(root.left,x,y,depth+1,root)
#         self.dfs(root.right,x,y,depth+1,root)
        
    
        