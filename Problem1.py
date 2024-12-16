# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        q = deque([root])
        if not root:
            return []

        while q:
            rightside = None

            for i in range(len(q)):
                node = q.popleft()

                rightside = node

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            if rightside:
                res.append(rightside.val)

        return res





