# https://leetcode.com/problems/cousins-in-binary-tree/description/

# Time Complexity: O(n)
# Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        pq = deque()

        x_found = False
        y_found = False
        x_parent = None
        y_parent = None

        if root is None:
            return False

        q.append(root)
        pq.append(None)

        while q:
            size = len(q)
            for i in range(size):
                qroot = q.popleft()
                pqroot = pq.popleft()

                if qroot.val == x:
                    x_found = True
                    x_parent = pqroot
            
                if qroot.val == y:
                    y_found = True
                    y_parent = pqroot

                if qroot.left is not None:
                    q.append(qroot.left)
                    pq.append(qroot)
            
                if qroot.right is not None:
                    q.append(qroot.right)
                    pq.append(qroot)

            if x_found and y_found and x_parent != y_parent:
                return True
            elif x_found and y_found and x_parent == y_parent:
                return False
            elif x_found or y_found:
                return False
                
        return False






        