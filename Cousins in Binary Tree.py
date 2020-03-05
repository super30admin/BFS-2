#BFS
#------------------------------------
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        
        if root == None:
            return False
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            x_found,y_found = False,False
            for _ in range(size):
                node = queue.popleft() 
                if (node.val) == x :
                    x_found = True
                if (node.val) == y:
                    y_found = True
               # if not node.left or not node.right:
                if (node.left != None and node.right != None ):
                    #print("fduu",node.left.val)
                    if node.left.val == x and node.right.val == y:
                        return False
                    if node.right.val == x and node.left.val == y:
                        return False
                if (node.left != None):
                    queue.append(node.left)
                if(node.right != None):
                    queue.append(node.right)
            if (x_found and y_found ):
                return True
            if (x_found or y_found ):
                return False
        return False

    
    
 #DFS
#-----------------------------------------------
