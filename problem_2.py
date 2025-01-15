from collections import deque


def isCousins(root, x, y):
    q = deque()
    q.append((root, None, 0))
    res = []
    level = 1
    while q:
        node, parent, level = q.popleft()
        if node.val == x or node.val == y:                
            res.append((level, parent))

        if node.left: q.append((node.left, node, level +1))
        if node.right: q.append((node.right, node, level+1))

    node_1, node_2 = res

    return node_1[0] == node_2[0] and node_1[1] != node_2[1]