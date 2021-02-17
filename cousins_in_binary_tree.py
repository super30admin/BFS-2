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
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root is None:
            return False
        
        queue = deque()
        queue.append([root, -1])
        
        while queue:
            size = len(queue)
            parentOfX = -1
            parentOfY = -1
            
            for i in range(size):
                front = queue.popleft()
                node = front[0]
                parent = front[1]
                if node.val == x:
                    parentOfX = parent
                elif node.val == y:
                    parentOfY = parent
                    
                if node.left:
                    queue.append([node.left, node.val])
                if node.right:
                    queue.append([node.right, node.val])
            if parentOfX != -1 and parentOfY != -1 and parentOfX != parentOfY:
                return True
            elif (parentOfX == -1 and parentOfY != -1) or (parentOfX != -1 and parentOfY == -1):
                return False
        return False