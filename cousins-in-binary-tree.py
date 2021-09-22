# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return False
        if root.left is None and root.right is None:
            return False
        
        q = [root] 
        
        while(q):
            size = len(q)
            x_flag = False 
            y_flag = False
            
            for i in range(size): 
                curr = q.pop(0)

                if curr.val == x:
                    x_flag = True
                if curr.val == y:
                    y_flag = True
                    
                if curr.left is not None and curr.right is not None:
                    if (curr.left.val == x and curr.right.val == y):
                        return False
                    if (curr.left.val == y and curr.right.val == x):
                        return False

                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
            
            if x_flag and y_flag:
                return True
        
 #BFS       
            