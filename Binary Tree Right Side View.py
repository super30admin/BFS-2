#Tc: O(n)
#SC: O(n)


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []

        result = []
        q = deque([root])  # Initialize queue with root

        while q:
            size = len(q)

            for i in range(size):
                curr = q.popleft()
                if i == size - 1:  # If it's the last node in this level, add to result
                    result.append(curr.val)

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

        return result