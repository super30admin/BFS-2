# Time Complexity : O(n)
# Space Complexity :O(h)
# Passed on Leetcode: yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

import queue
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return None
        q = queue.Queue()
        q.put(root)
        res = []
        while not q.empty():
            for i in range(q.qsize()):
                val = q.get()
                if val.left:
                    q.put(val.left)
                if val.right:
                    q.put(val.right)
            res.append(val.val)
        return res
            
