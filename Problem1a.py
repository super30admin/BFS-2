from collections import deque


class Solution(object):
    def rightSideView(self, root):
        """
        Time complexity - O(N), N --> number of nodes in the binary tree
        Space complexity - O(M), M --> maximum number of nodes at any level of the tree
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []  # Initialize the result list to store the rightmost values
        if root is None:
            return result  # If the root is None, return an empty result

        q = deque()  # Initialize a queue for BFS traversal
        q.append(root)  # Enqueue the root node

        while q:  # Perform BFS traversal while the queue is not empty
            size = len(q)  # Get the number of nodes in the current level

            for i in range(size):
                curr = q.popleft()  # Dequeue the front node

                if i == size - 1:
                    # If it's the rightmost node, add its value to the result
                    result.append(curr.val)

                if curr.left is not None:
                    q.append(curr.left)  # Enqueue the left child if it exists

                if curr.right is not None:
                    # Enqueue the right child if it exists
                    q.append(curr.right)

        return result  # Return the list of rightmost values
