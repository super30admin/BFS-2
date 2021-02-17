'''
Time complexity: O(n)
Space complexity: O(max_diameter)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        output = []
        if root is None:
            return output
        queue = deque()
        queue.append(root)
        
        while queue:
            size = len(queue)
            
            for i in range(size):
                front = queue.popleft()
                if i == size - 1:
                    output.append(front.val)
                if front.left:
                    queue.append(front.left)
                if front.right:
                    queue.append(front.right)
        return output