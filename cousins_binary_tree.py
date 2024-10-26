# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        x_found = False
        y_found = False
        x_parent = None
        y_parent = None

        q = deque([root])
        pq = deque([None])

        while q:
            size = len(q)

            for _ in range(size):
                curr = q.popleft()
                parent = pq.popleft()
                if curr.val == x:
                    x_found = True
                    x_parent = parent
                if curr.val == y:
                    y_found = True
                    y_parent = parent
                if curr.left:
                    q.append(curr.left)
                    pq.append(curr)
                if curr.right:
                    q.append(curr.right)
                    pq.append(curr)
            if x_found and y_found:
                return x_parent != y_parent

            if x_found or y_found:
                return False
        return False


# time complexity is O(n)
# space compleity is O(n/2)
