"""
BFS Approach -
TC - O(n)
SC - O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None: return []

        rtnData = []
        q = deque()
        q.append(root)

        while q:
            qsize = len(q)
            for i in range(qsize):
                curr = q.popleft()
                # append size-1st elemet in the list
                if i == qsize-1:
                    rtnData.append(curr.val)
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
        return rtnData