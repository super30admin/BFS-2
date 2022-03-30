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
      
        q=[root]
        while(q):
          
            size = len(q)
            x_found = False
            y_found = False
            for i in range(size):
                curr= q.pop(0)
                if curr.val == x:
                     x_found = True
                if curr.val == y:
                     y_found = True
                if curr.left and curr.right:
                  
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                   
            if x_found and y_found:
      
                return True
            if x_found or y_found:
                
                return False