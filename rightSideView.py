# Time Complexity : O(n) 
# Space Complexity : O(h) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q = deque([root,])
        if root is None: 
            return []
        result = []
        while q:
            size = len(q)
            for i in range(0,size):
                curr = q.popleft()
                if i == size-1:
                    result.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return result
                    
            
