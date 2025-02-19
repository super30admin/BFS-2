# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque([root])
        pq = deque([root])

        while q:
            size = len(q)
            x_found = False
            y_found = False
            x_parent = None
            y_parent = None
            for i in range(size):
                curr = q.popleft()
                pcurr = pq.popleft()
                if curr.val == x:
                    x_found = True
                    x_parent = pcurr
                if curr.val == y:
                    y_found = True
                    y_parent = pcurr
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