"""
problem_2: Cousins in Binary Tree
TC: O(N)
SC: O(N)
Approach: BFS
"""


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False

        queue = [root]
        x_found = False
        y_found = False

        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.pop(0)
                if node.left and node.right:
                    if node.left.val == x and node.right.val == y:
                        return False
                    elif node.left.val == y and node.right.val == x:
                        return False

                if node.val == x:
                    x_found = True
                elif node.val == y:
                    y_found = True

                if node.left:
                    queue.append(node.left)

                if node.right:
                    queue.append(node.right)

            if x_found and y_found:
                return True

            if x_found or y_found:
                return False

        return False
