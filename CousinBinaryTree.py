# Time Complexity: O(n) n is the number of nodes in the tree
# Space Complexity: O(n) n is the number of nodes at leaf
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        #BFS: O(n) & O(n)
        q = deque()

        q.append(root)

        while q:
            size = len(q)
            xFound = False
            yFound = False
            for _ in range(size):
                curr = q.popleft()
                if curr.val == x:
                    xFound = True
                if curr.val == y:
                    yFound = True
                if curr.left != None and curr.right != None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)

            if xFound and yFound:
                # Both nodes are at same level
                return True
            if xFound or yFound:
                # One of the parent is at same level
                return False
        return False