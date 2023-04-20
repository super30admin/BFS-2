# Time Complexity: O(n) because we are traversing the tree once
# Space Complexity: O(n) because we are using a queue to store the nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We will use BFS to traverse the tree level by level. We will keep track of the size of the 
queue at each level. We will add the last node of each level to the answer list.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # BFS
        if root == None:
            return []

        answer = []
        q = Queue()
        q.put(root)

        while not q.empty():
            size = q.qsize()
            for i in range(size):
                node = q.get()
                if node.left != None: q.put(node.left)
                if node.right != None: q.put(node.right)
                if i == size - 1: answer.append(node.val)

        return answer