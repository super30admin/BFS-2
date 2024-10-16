#199. Binary Tree Right Side View : Using Queue BFS
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root:
            return result

        q = deque([root])

        while(len(q) != 0):
            size = len(q)

            for i in range(size):
                curr = q.popleft()
                if i == size-1:
                    result.append(curr.val)

                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
        return result
        

        