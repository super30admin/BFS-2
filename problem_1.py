# TC: O(n)
# SC: O(w) - width of tree

from collections import deque

def rightSideView(root):
    if not root: return []
    q = deque()
    q.append(root)
    result = []
    while q:
        level = len(q)
        for _ in range(level):
            sub_node = q.popleft()
            if sub_node.left: q.append(sub_node.left)
            if sub_node.right: q.append(sub_node.right)
        result.append(sub_node.val)
    return result