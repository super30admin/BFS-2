from collections import deque


class Solution(object):
    def isCousins(self, root, x, y):
        """
        Time complexity: O(N), where N is the number of nodes in the binary tree.
        Space complexity: O(N), where N is the number of nodes in the binary tree.
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        q = deque()  # Initialize a queue to perform level order traversal
        pq = deque()  # Initialize a parent queue to keep track of the parents of each node
        q.append(root)  # Add the root node to the queue
        # Add None to the parent queue to represent the parent of the root (None)
        pq.append(None)

        while q:
            size = len(q)
            x_found, y_found = False, False
            x_parent, y_parent = None, None

            for i in range(size):
                curr = q.popleft()  # Remove the front node from the queue
                currP = pq.popleft()  # Remove the parent of the current node from the parent queue

                if curr.val == x:  # Check if the current node value matches x
                    x_found = True
                    x_parent = currP

                if curr.val == y:  # Check if the current node value matches y
                    y_found = True
                    y_parent = currP

                if curr.left is not None:
                    q.append(curr.left)  # Add the left child to the queue
                    # Add the current node as the parent to the parent queue
                    pq.append(curr)

                if curr.right is not None:
                    q.append(curr.right)  # Add the right child to the queue
                    # Add the current node as the parent to the parent queue
                    pq.append(curr)

            if x_found and y_found:  # If both x and y are found
                return x_parent != y_parent  # Check if they have different parents
            # If either x or y is found (but not both)
            elif x_found or y_found:
                return False  # They cannot be cousins, return False

        return False  # If neither x nor y is found, return False
