#Time Complexity :O(N)
#Space Complexity :O(N)
#Did this code successfully run on Leetcode :yes
#Method: BFS

# Definition for a binary tree node.
from ast import List
import collections

class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def rightSideView(self, root: [TreeNode]) -> List[int]:
        result =[]
        if root is None:
            return result
        q = collections.deque()
        q.append(root)
        
        while q:
            qlen = len(q)
            for i in range(qlen):
                curr = q.popleft()
                if i == qlen - 1:
                    result.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return result

        