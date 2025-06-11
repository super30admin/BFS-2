"""
Apply BFS and traverse tree level-by-level
At each level, check if both x and y exist, and if they have different parents
If yes, return True. If one found and not other, return False.
"""
"""
Time Complexity: O(N) – visit all nodes once
Space Complexity: O(W) – width of tree
"""

from collections import deque
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class cousinsBinary:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        
        queue = deque([(root, None)])  

        while queue:
            size = len(queue)
            x_parent = y_parent = None

            for _ in range(size):
                node, parent = queue.popleft()
                if node.val == x:
                    x_parent = parent
                if node.val == y:
                    y_parent = parent
                if node.left:
                    queue.append((node.left, node))
                if node.right:
                    queue.append((node.right, node))
            
          
            if x_parent and y_parent:
                return x_parent != y_parent
            if x_parent or y_parent:
                return False 

        return False

if __name__ == "__main__":

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.right = TreeNode(5)

    obj = cousinsBinary()
    print(obj.isCousins(root, 5, 4))  
    print(obj.isCousins(root, 4, 3))  
