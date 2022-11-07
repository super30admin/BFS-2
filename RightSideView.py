# TC: O(n)
# SC: O(h)
# Does this code run on Leetcode: Yes
# Did you find any difficulties while coding this: No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        res = []
        q = collections.deque([root])
        
        while q:
            rightSide = None
            qLen = len(q)
            # this for loop works on each level of the queue. We store every node
            # in the variable rightnode and it gets updated for every loop.
            # So, by the end of the complete level, the node in the rightnode
            # is the right-most value. 
            for i in range(qLen):
                node = q.popleft()
                if node:
                    rightSide = node
                    q.append(node.left)
                    q.append(node.right)
            if rightSide:
                res.append(rightSide.val) 
        return res           