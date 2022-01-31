# Time Complexity o(N)
# Space Complexity o(n)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        level = 0
        parent = None
        
        queue = collections.deque([(root , parent)])
        
        level = 0
        while(len(queue)>0):
            level +=1
            size = len(queue)
            
            for i in range(size):
                
                node , parent = queue.popleft()
                
                if node.val == x:
                    x = (level,parent)
                if node.val == y:
                    y = (level,parent)
                
                parent = node.val
                
                if node.left != None:
                    queue.append((node.left , parent))
                
                if node.right != None:
                    queue.append((node.right,parent))
                    
        return x[0] == y[0] and x[1] != y[1]
                                  
                                 
                
                
                