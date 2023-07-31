# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = collections.deque()
        pq = collections.deque()
        q.append(root)
        pq.append(None)
        x_found = False
        y_found = False
        x_parent = None
        y_parent = None

        while q:
            length = len(q)
            for i in range(length):
                node = q.popleft()
                pnode = pq.popleft()
                if node.val == x:
                    x_found = True
                    x_parent = pnode
                if node.val == y:
                    y_found = True
                    y_parent = pnode

                if node.left:
                    q.append(node.left)
                    pq.append(node)
                if node.right:
                    q.append(node.right)
                    pq.append(node)

            if x_found and y_found and x_parent != y_parent :
                return True
            if x_found or y_found:
                return False
        return False
