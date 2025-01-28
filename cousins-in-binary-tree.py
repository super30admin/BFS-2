# tc O(n), sc O(n).
from collections import deque
queue = deque([root])
px = py = False

while queue:
    for _ in range(len(queue)):
        node = queue.popleft()
        if node.left:
            queue.append(node.left)
            if node.left.val == x:
                px = node.val
            if node.left.val == y:
                py = node.val
        if node.right:
            queue.append(node.right)
            if node.right.val == x:
                px = node.val
            if node.right.val == y:
                py = node.val
    if px or py:
        return px and py and px != py
return False