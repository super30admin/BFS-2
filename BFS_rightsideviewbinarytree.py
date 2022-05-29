#Time Complexity : O(n)
#Space Complexity : O(h)
#Did your code run on leetcode : yes
#Approach : Level order traversal BFS

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        
        if root == None: return result
        
        queue = deque()
        queue.append(root)
        
        while(len(queue) != 0):
            size = len(queue)
            
            for i in range(size):
                current = queue.popleft()
                if i == size - 1:
                    result.append(current.val)
                if current.left != None: queue.append(current.left)
                if current.right != None: queue.append(current.right)
                    
        return result
