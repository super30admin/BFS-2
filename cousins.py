# DFS
# Time Complexity : O(n)
# Space Complexity : O(n)

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def isCousins(root, x, y):
    """
    :type root: TreeNode
    :type x: int
    :type y: int
    :rtype: bool
    """
    parent = {}
    depth = {}
    def dfs(node, par, level):
        if node:
            depth[node.val] = level
            parent[node.val] = par
            dfs(node.left, node.val, level + 1)
            dfs(node.right, node.val, level + 1)
    
    dfs(root, None, 0)
    return depth[x] == depth[y] and parent[x] != parent[y]

# BFS
# Time Complexity : O(n)
# Space Complexity : O(n)


from collections import deque

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def isCousins(root, x, y):
    """
    :type root: TreeNode
    :type x: int
    :type y: int
    :rtype: bool
    """
    if not root:
        return False
    
    queue = deque([(root, None)])
    parent = {}
    depth = {}
    level = 0
    
    while queue:
        level_size = len(queue)
        for _ in range(level_size):
            node, par = queue.popleft()
            if node:
                parent[node.val] = par
                depth[node.val] = level
                queue.append((node.left, node.val))
                queue.append((node.right, node.val))
        level += 1
    
    return depth.get(x) == depth.get(y) and parent.get(x) != parent.get(y)
