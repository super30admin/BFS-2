class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque([(root, None)]) 

        while q:
            size = len(q)
            x_parent = y_parent = None

            for _ in range(size):
                node, parent = q.popleft()

                if node.val == x:
                    x_parent = parent
                if node.val == y:
                    y_parent = parent

                if node.left:
                    q.append((node.left, node))
                if node.right:
                    q.append((node.right, node))

            
            if x_parent and y_parent:
                return x_parent != y_parent
            if x_parent or y_parent:
                return False

        return False