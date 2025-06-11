# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Space Complexity - o(1)
# Time Complexity - o(n)
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        res = []

        if not root:
            return res

        q = deque()
        q.append(root)

        while q:
            size = len(q)

            for i in range(size):
                node = q.popleft()
                if i==size-1:
                    res.append(node.val)
                if node.left:
                    q.append(node.left)
                
                if node.right:
                    q.append(node.right)

        return res