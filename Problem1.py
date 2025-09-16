"""
TC: O(N) {we iterate linearly on the list}
SC: O(W) {We use the queue to store the nodes at each level and its technically the width of the tree, at max ie on bottom its at most N/2}

Approach:

We leverage the level order traversal of the BFS where we traverse all the nodes in each level and store the last node of each level in our 
result

The problem ran successfully on LeetCode.
"""
from collections import deque
from typing import List, Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        q = deque([root])
        res = [root.val]
        
        while q:

            for i in range(len(q)):
                curr = q.popleft()

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            if q:
                right = q.pop()
                q.append(right)
                res.append(right.val)

        return res
