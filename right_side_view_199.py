# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        q = deque([root])
        l = []
        while q:
            cnt = len(q)
            level = []
            for i in range(cnt):
                cur = q.popleft()
                if cur:
                    level.append(cur.val)
                    if cur.left:
                        q.append(cur.left)
                    if cur.right:
                        q.append(cur.right)
            l.append(level)

        return [x[0] for x in l]

