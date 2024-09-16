#DFS way:
Time complexity - O(n)
space complexity - O(h)
Done on Leetcode: Yes
Problems faced: None
Description: we do DFS traversal and then we go to each and every node and check if it is matching with any of the given nodes.If yes get the node value and the depth of that node .TO be cousins they have to be at the same level and not the same parents.
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# DFS solution
from collections import deque
class Solution(object):
    def helper(self,root,root1,count,x):
        if root==None:
            return
        if root.val==x:
            return((root1.val,count))
        left=self.helper(root.left,root,count+1,x)
        right=self.helper(root.right,root,count+1,x)
        if left!=None:
            return left
        elif right!=None:
            return right
        else:
            return None
        
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        if root==None:
            return True
        x_value=self.helper(root,root,0,x)
        y_value=self.helper(root,root,0,y)
        if x_value[0]!=y_value[0] and x_value[1]==y_value[1]:
            return True
        return False
            
#BFS traversal
Time complexity - O(n)
space complexity - O(n/2)
Done on Leetcode: Yes
Problems faced: None
Description:
we do a BFS traversal and then store the parent,level of a particular node and at every level during traversal we check the if the values are present and they have different parents.
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# BFS solution
from collections import deque
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        if root==None:
            return True
        
        d=deque([[root,root]])
        while (len(d)!=0):
            size=len(d)
            x_parent=False
            y_parent=False
            for i in range(size):
                d1=d.popleft()
                node=d1[0]
                parent=d1[1]
                if node.val==x:
                    x_parent=True
                    val_parent_x=parent.val
                if node.val==y:
                    y_parent=True
                    val_parent_y=parent.val
                if node.left!=None:
                    d.append([node.left,node])
                if node.right!=None:
                    d.append([node.right,node])
            if x_parent==True and y_parent==True and val_parent_x!=val_parent_y:
                return True
        return False
            
                
        