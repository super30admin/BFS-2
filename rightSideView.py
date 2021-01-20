# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        """
        Can do a BFS-
            - Use a queue
                - When we hit a node that the currList size is the same as the level 
                    then put it into res array         
        """
        res = []
        if not root:
            return res
        
        queue = deque([root])
        
        while queue:
            size = len(queue)
            for i in range(size):
                root = queue.popleft()
                
                if i == size-1:
                    res.append(root.val)
                    
                if root.left:
                    queue.append(root.left)
                if root.right:
                    queue.append(root.right)
            
        return res