'''
    Time Complexity: O(n)
    Space Complexity: O(n/2)
    Approach: BFS - last element in the result
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        if not root:
            return result

        queue = deque()
        queue.append(root)
        size = len(queue)

        while len(queue):
            for i in range(size):
                node = queue.popleft()

                if i == size - 1:
                    result.append(node.val)

                if node.left:
                    queue.append(node.left)

                if node.right:
                    queue.append(node.right)
            
            size = len(queue)

        return result
        