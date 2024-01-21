from collections import deque

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False

        # Queues for level order traversal and parent tracking
        node_queue = deque([root])
        parent_queue = deque([None])

        while node_queue:
            size = len(node_queue)
            x_found = y_found = False
            parent_x = parent_y = None

            for _ in range(size):
                curr = node_queue.popleft()
                parent = parent_queue.popleft()

                if curr.val == x:
                    x_found = True
                    parent_x = parent

                if curr.val == y:
                    y_found = True
                    parent_y = parent

                if curr.left:
                    node_queue.append(curr.left)
                    parent_queue.append(curr)

                if curr.right:
                    node_queue.append(curr.right)
                    parent_queue.append(curr)

            if x_found and y_found:
                return parent_x != parent_y

            if x_found or y_found:
                return False

        return False
