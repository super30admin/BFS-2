"""
TC:O(N) visit all N nodes in the worst case
SP: O(N)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque([(root, None)])
        p = []
        level=0
        while q:
            for _ in range(len(q)):
                node, parent = q.popleft()
                if node.val == x or node.val==y:
                    if not p:
                        p.append((parent, level))
                    else:
                        if p[0][0]!=parent and p[0][1]==level:
                            return True
                if node.left:
                    q.append((node.left, node))
                if node.right:
                    q.append((node.right, node))
            level+=1
        return False

                



        