"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No



"""

# Cousins in binary tree

# Approach - 1
# BFS

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
        father=[]
        level=[]
        q=collections.deque()
        q.append(root)
        count=0

        if root.val==x or root.val==y:
            father.append(root)
            level.append(count)

        while q:
            size=len(q)
            count+=1
            for i in range(size):
                curr=q.popleft()
                if curr.left:
                    q.append(curr.left)
                    
                    if curr.left.val==x or curr.left.val==y:
                        father.append(curr)
                        level.append(count)
                    
                if curr.right:
                    q.append(curr.right)
                    
                    if curr.right.val==x or curr.right.val==y:
                        father.append(curr)
                        level.append(count)
                    

        if level[0]==level[1] and father[0]!=father[1]:
            # same level but with different fathers
            return True
        else:
            return False





# Approach - 2
# DFS

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def __init__(self):
        self.x_depth=0
        self.y_depth=0
        self.x_parent=None
        self.y_parent=None

    def isCousins(self, root, x, y):

        if not root:
            return root
        self.dfs(root,x,y,0,None)
        if self.x_depth==self.y_depth and self.x_parent!=self.y_parent:
            return True
        else:
            return False

    def dfs(self,root,x,y,level,parent):
        if not root:
            return
        if root.val==x:
            self.x_depth=level
            self.x_parent=parent
        if root.val==y:
            self.y_depth=level
            self.y_parent=parent
        self.dfs(root.left,x,y,level+1,root)
        self.dfs(root.right,x,y,level+1,root)
