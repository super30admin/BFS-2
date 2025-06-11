# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Space Complexity - o(n)
# Time Complexity - o(n)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        res = []

        q = deque()
        q.append(root)

        while q:
            size = len(q)
            x_found = False
            y_found = False

            for i in range(size):
                node = q.popleft()

                if node:
                    if (node.left and node.left.val == x and node.right and node.right.val == y) or node.left and node.left.val == y and node.right and node.right.val == x:
                        print('false')
                        return False

                if node and node.val == x:
                    x_found = True

                if node and node.val == y:
                    y_found = True

                if node.left:
                    q.append(node.left)
                
                if node.right:
                    q.append(node.right)

            if x_found and y_found:
                return True

            if x_found or y_found:
                return False

             


        return False

