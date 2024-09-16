#Time Complexity : O(N) where N is the Number of Nodes
#Space Complexity : O(H) height of the Tree

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
        
        def dfs(root , x,y,depth,parent):
            if root ==None:
                return False
            if root.val == x:
                self.x_depth = depth
                self.x_parent = parent
            if root.val == y:
                self.y_depth = depth
                self.y_parent = parent
            
            dfs(root.left,x,y,depth+1,root)
            dfs(root.right,x,y,depth+1,root)
        
        dfs(root,x,y,0,None) 
        return self.x_depth == self.y_depth and self.x_parent!=self.y_parent
====================================================================================
#Time Complexity : O(N) where N is the Number of Nodes
#Space Complexity : O(B) Maximum Bredth N/2

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
        
        Queue = []
        Queue.append(root)
        
        while len(Queue)>0:
            size = len(Queue)
            x_found = False
            y_found = False
            for i in range(size):
                curr = Queue.pop(0)
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                if curr.left!=None and curr.right!=None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.left !=None:
                    Queue.append(curr.left)
                if curr.right !=None:
                    Queue.append(curr.right)
            if x_found == True and y_found ==True:
                return True
        return False
                