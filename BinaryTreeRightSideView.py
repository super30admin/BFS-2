# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # Time Complexity is O(n)
        # Space Complexity is O(n/2), where n is the number of nodes
        # Use Queue to perform BFS and traverse the tree in Level Order.
        # Capture the last element of each level and return
        if root is None:
            return []
        
        q = deque([root])
        
        output = []
        
        while(q):
            
            size = len(q)
            output.append(q[size-1].val)
            
            for i in range(size):
                curr = q.popleft()
                if(curr.left):
                    q.append(curr.left)
                if(curr.right):
                    q.append(curr.right)
        return output