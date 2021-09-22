# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right



class Solution:
    #BFS Solution
    
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root is None:
            return result
        
        q = [root]
        
        while(q):
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                #will be 0 if we want left side 1st element
                if i == size-1:
                    result.append(curr.val)
                    
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
                
        return result
                
            
            
        