# tc O(n), sc O(max breadth = n).
if not root:
    return []
from collections import deque
queue = deque([root])
res = []
while queue:
    last_node = None
    for _ in range(len(queue)):
        node = queue.popleft()
        last_node = node.val
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
    res.append(last_node)

return res