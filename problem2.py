# time: O(n)
# space: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root==None:
            return None
        
        q = collections.deque()
        q.append(root)
        
        while q:
            size = len(q)
            
            x_found = False
            y_found = False
            
            for i in range(size):
                node = q.popleft()
                
                if node.val==x:
                    x_found = True
                if node.val==y:
                    y_found=True
                
                if node.left and node.right:
                    if node.left.val==x and node.right.val==y:
                        return False
                    
                    if node.right.val==x and node.left.val==y:
                        return False
                    
                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)
            
            if x_found and y_found:
                    return True
            
        return False
            
            
        