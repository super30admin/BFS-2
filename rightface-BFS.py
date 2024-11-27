"Time Complexity is O(N)"
"Space Complexity is O(N)"

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        if root is None:
            return result

        queue = deque([root])

        while(queue):
            size = len(queue)
            for i in range(size):
                value = queue.popleft()
                if (i == size-1):
                    result.append(value.val)
                if value.left!=None:
                    queue.append(value.left)
                if value.right != None:
                    queue.append(value.right)

        return result        