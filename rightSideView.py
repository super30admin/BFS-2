'''
Time: O(n)
Space: O(n)
'''
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
        res=[]
        que=deque()
        que.append(root)
        
        while que:
            size=len(que)
            for i in range(size):
                current=que.popleft()
                if i==size-1:
                    res.append(current.val)
                
                if current.left is not None:
                    que.append(current.left)
                
                if current.right is not None:
                    que.append(current.right)
        return res
                
                    