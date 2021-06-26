# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        if not root: return result
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if i == size-1:
                    result.append(curr.val)
                if curr.left is not None: q.append(curr.left)
                if curr.right is not None: q.append(curr.right)    
            
        
        return result

#Time complexity is O(n) and space complexity is O(n)
#Using BFS to process all the children of a node and then pushing the last child to result
        