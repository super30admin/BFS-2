##Time Complexity : O(n)
##Space Complexity : O(h)
##Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        q = collections.deque([root])
        while q:
            rightside = None
            qlen = len(q)
            for i in range(qlen):
                node = q.popleft()
                if node:
                    rightside = node
                    q.append(node.left)
                    q.append(node.right)
                    
            if rightside:
                result.append(rightside.val)
        return result
        