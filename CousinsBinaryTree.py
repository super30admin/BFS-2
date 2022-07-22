# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity => O(N)
# Space Complexity => O(N)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if(root is None or x==y):
            return False
        q = []
        q.append(root)
        while(len(q)!=0):
            size = len(q)
            x_f, y_f = False, False
            for i in range(size):
                curr = q.pop(0)
                if(curr.val == x):
                    x_f = True
                if(curr.val == y):
                    y_f = True
                if(curr.left is not None and curr.right is not None):
                    if(curr.left.val == x and curr.right.val == y):
                        return False
                    if(curr.left.val == y and curr.right.val == x):
                        return False
                if(curr.left is not None):
                    q.append(curr.left)
                if(curr.right is not None):
                    q.append(curr.right)
            if(x_f is True and y_f is True):
                return True
            if(x_f is True or y_f is True):
                return False
        return False 
        
            
        