# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q=deque()
        q.append(root)
        parentQ=deque()
        parentQ.append(None)
        xFound=False
        yFound=False
        xParent=None
        yParent=None
        while q:
            qLen=len(q)
            for i in range(qLen):
                curr=q.popleft()
                parent=parentQ.popleft()
                if curr:
                    if curr.val==x:
                        xFound=True
                        xParent=parent
                    if curr.val==y:
                        yFound=True
                        yParent=parent
                    if curr.left:
                        q.append(curr.left)
                        parentQ.append(curr)
                    if curr.right:
                        q.append(curr.right)
                        parentQ.append(curr)
            if xFound and yFound:
                return xParent!=yParent
            if xFound or yFound:
                return False
        return False
            
                