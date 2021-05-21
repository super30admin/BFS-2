# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        if root is None:
            return None
        
        queue = []
        solution = []
        
        queue.append(root)
        
        while queue:
            
            size = len(queue)
            for i in range(size):     
                curr = queue.pop(0)
                if i==size-1:
                    solution.append(curr.val)
                
                if curr.left is not None:
                    queue.append(curr.left)
                if curr.right is not None:
                    queue.append(curr.right)
            
        
        return solution
    
#  This is bfs solution. 
#  Time complexity is O(n) and space complexity is O(n/2) == O(n)
        
