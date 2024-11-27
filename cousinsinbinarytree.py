"Time Complexity is O(N)"
"Space Complexity is O(N)"

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

        x_parent = -1
        y_parent = -2

        queuec = deque([root])
        queuep = deque([None])

        while(queuec):
            for i in range(len(queuec)):
                value = queuec.popleft()
                value2 = queuep.popleft()

                if value.val == x:
                    x_found = True
                    x_parent = value2
                if value.val == y:
                    y_found = True
                    y_parent = value2
                if value.left:
                    queuec.append(value.left)
                    queuep.append(value)
                if value.right:
                    queuec.append(value.right)
                    queuep.append(value)
                
            if x_found and y_found:
                return x_parent != y_parent
            
            if x_found or y_found:
                return False
            
        return False







        