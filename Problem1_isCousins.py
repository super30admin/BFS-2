# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return True
        
        queue = []
        
        queue.append(root)
        
        while queue:
            size= len(queue)
            is_x_found = False
            is_y_found = False
            
            for i in range(0,size):
                curr = queue.pop(0)
                
                if curr.val == x:
                    is_x_found = True
                if curr.val == y:
                    is_y_found = True
                # if node has left and right child, is they are siblings
                if curr.left!=None and curr.right!=None:
                    if (curr.left.val==x and curr.right.val==y) or (curr.left.val==y and curr.right.val==x):
                        return False
                if curr.left!=None:
                    queue.append(curr.left)
                if curr.right!=None:
                    queue.append(curr.right)
                    
            if (is_x_found and is_y_found):
                return True
                
        return False
                    
                
                
        
        