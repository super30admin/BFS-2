#TC: O(n)
#SC: O(n)
#Program ran on Leetcode successfully

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
        queue = []
        queue.append(root)
        
        while queue:
            size = len(queue)
            x_found = False
            y_found = False
            for i in range(size):
                curr = queue.pop(0)
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                
                if curr.left is not None and curr.right is not None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                
                if curr.left is not None:
                    queue.append(curr.left)
                if curr.right is not None:
                    queue.append(curr.right)
                
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
        
        return False
        