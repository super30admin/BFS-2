# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        q = deque()
        parent_q = deque()

        x_found = False
        y_found = False

        x_parent = None
        y_parent = None

        
        q.append(root)
        parent_q.append(None)

        while q:
            size = len(q)

            # Reset for every level
            x_found = False
            y_found = False
            x_parent = None
            y_parent = None

            for i in range(size):
                curr = q.popleft()
                parent = parent_q.popleft()

                if curr.val == x:
                    x_found = True
                    x_parent = parent

                if curr.val == y:
                    y_found = True
                    y_parent = parent

                if curr.left is not None:
                    q.append(curr.left)
                    parent_q.append(curr)

                if curr.right is not None:
                    q.append(curr.right)
                    parent_q.append(curr)


            # Case 1: Both x and y were found on this level
            if x_found and y_found:
                # They are cousins only if they have different parents
                if x_parent != y_parent:
                    return True
                else:
                    return False

             # Case 2: Only one of x or y was found on this level
            if x_found or y_found:
                # They cannot be cousins because cousins must be on the same level
                return False

        return False

# Time complexity: O(n), we visit each node once.
# Space complexity: O(w), where w is the maximum number of nodes at any level.
# For a complete/balanced binary tree, the last level can contain about n/2 nodes.
# O(n/2) simplifies to O(n).

