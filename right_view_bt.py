# O(N) TIME AND O(D) SPACE WHERE N IS NO.OF NODES AND D IS DIAMETER
from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        output = []
        que = deque()
        que.append(root)
        while que:
            size = len(que)
            for i in range(size):
                popped = que.popleft()
                if i == size - 1:
                    output.append(popped.val)
                if popped.left is not None:
                    que.append(popped.left)
                if popped.right is not None:
                    que.append(popped.right)
        return output
        