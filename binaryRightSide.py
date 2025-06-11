"""
Apply BFS using queue
For each level, add the last node's value to result
Repeat same for all levels
"""
"""
Time Complexity: O(N) — visit all nodes once
Space Complexity: O(W) — max width of tree
"""


from collections import deque
from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class binaryRightSide:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        
        result = []
        queue = deque([root])

        while queue:
            level_length = len(queue)
            for i in range(level_length):
                node = queue.popleft()
      
                if i == level_length - 1:
                    result.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return result


if __name__ == "__main__":

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(4)

    obj = binaryRightSide()
    print(obj.rightSideView(root))