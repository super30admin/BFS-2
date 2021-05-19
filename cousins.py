# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        '''
        TC : O(N) // 
        SC : O(1) // 
        
        Approach  : 
            Apply level order traversal and get parent and height of x and y  nodes
            if both have same height and diffrent parent then return True 
            else return False
            
        '''
        if not root: return False
        q = [root]       
        c = 1
        x_h = y_h =None
        while q:
            l = len(q)
            while l:
                e = q.pop(0)
                if e.left: 
                    q.append(e.left)
                    if e.left.val == x:
                        x_h = c
                        x_par = e
                    if e.left.val == y:
                        y_h = c
                        y_par = e
                if e.right: 
                    q.append(e.right)
                    if e.right.val == x:
                        x_h = c
                        x_par = e
                    if e.right.val == y:
                        y_h = c
                        y_par = e
                if x_h  and y_h and x_h == y_h and x_par != y_par: return True
                l -= 1
            c += 1          
        return False