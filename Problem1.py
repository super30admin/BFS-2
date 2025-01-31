# BFS: After traversing each level using a queue size in the end append the last value which is being updated at each iteration of the queue
# TC: O(N)
# SC: O(N)
# Yes, this worked in leetcode


from queue import Queue
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q = Queue()
        q.put(root)
        res = []
        while not q.empty():
            size = q.qsize()
            rightmost = None
            for i in range(size):
                curr = q.get()
                rightmost = curr.val
                if curr.left:
                    q.put(curr.left)
                if curr.right:
                    q.put(curr.right)
            res.append(rightmost)
        return res
