# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(N)
# Space Complexity: O(N)

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = collections.deque()
        pq = collections.deque()

        q.append(root)
        pq.append(None)

        found_x = False
        found_y = False

        px = None
        py = None

        while q: 
            size = len(q)
            for _ in range(size):
                node = q.popleft()
                pnode = pq.popleft()

                if node.val == x:
                    found_x = True
                    px = pnode

                if node.val == y: 
                    found_y = True
                    py = pnode
                
                if node.left: 
                    q.append(node.left)
                    pq.append(node)

                if node.right:
                    q.append(node.right)
                    pq.append(node)

            if found_x and found_y and px != py:
                return True
            elif found_x or found_y: 
                return False

            
