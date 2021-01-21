# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        #BFS Approach
        queue = []
        queue.append(root)
        
        while queue:
            # to make a distinct group of level we are making use of size(length)
            queue_len = len(queue)
            #initial it will be false
            x_found = False
            y_found = False
            
            for i in range(len(queue)):
                node = queue.pop(0)
                # if node.val matches with x return True
                if node.val == x:
                    x_found = True
                if node.val == y:
                    y_found = True
                
                # return false if it at same node 
                if node.left != None and node.right != None:
                    if node.left.val == x and node.right.val == y: 
                        return False
                    if node.left.val == y and node.right.val == x:
                        return False
                # process the baby nodes left and right    
                if node.left != None:
                    queue.append(node.left)
                    
                if node.right != None:
                    queue.append(node.right)
            # if we find x and y at same level then true
            if x_found and y_found:
                return True
            #if one found at that level and other didn't found that is it can be below
            if x_found or y_found:
                return False
        # if not return false        
        return False
