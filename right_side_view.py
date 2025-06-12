# BFS
# Time Complexity : O(n)
# Space Complexity : O(n)
from collections import deque

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def rightSideView(root):
    """
    :type root: TreeNode
    :rtype: List[int]
    """
    if not root:
        return []
    
    result = []
    queue = deque([root])
    
    while queue:
        level_size = len(queue)
        for i in range(level_size):
            node = queue.popleft()
            if i == level_size - 1:
                result.append(node.val)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
    
    return result


# DFS
# Time Complexity : O(n)
# Space Complexity : O(h)
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def rightSideView(root):
    """
    :type root: TreeNode
    :rtype: List[int]
    """
    result = []
    def dfs(node, level):
        if not node:
            return
        if level == len(result):
            result.append(node.val)
        dfs(node.right, level + 1)
        dfs(node.left, level + 1)
    
    dfs(root, 0)
    return result
