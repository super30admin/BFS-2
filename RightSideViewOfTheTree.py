from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        # Time Complexity - O(N)
        # Space Complexity - O(H) where H is the height of the tree
        # Algorithm - BFS
        # Appending the value of only the last element of queue for a particular level to the output
        
        if root == None:
            return root
        
        output = []  # For storing the final output
        queue = deque() # queue for bfs
        queue.append(root)
        
        while queue:
            
            qsize=len(queue)
            for i in range(qsize):
                cur=queue.popleft()
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
                    
            output.append(cur.val) # Appending the last value of the queue to the output
            
        return output
        
        
        