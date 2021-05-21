# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
        
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        if root is None:
            return False
        
        queue = []
        
        queue.append(root)
        
        while queue:
            size = len(queue)
            xFound = False
            yFound = False
            
            for i in range(size):
                curr = queue.pop(0)
                
                if curr.val == x:
                    xFound = True
                if curr.val == y:
                    yFound = True

                if curr.left!=None and curr.right!=None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    elif curr.left.val == y and curr.right.val == x:
                        return False

                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
                    
            if xFound and yFound:
                return True

        return False
    
    
#      BFS solution..O(n) is time complexity and O(n) is space complexity.


        
        
            
        
        
        
        
        
        
        
        
        
        
