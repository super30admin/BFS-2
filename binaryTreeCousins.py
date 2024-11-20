"""
Time complexity: O(N)
Space complexity: O(N)
Compiled on leetcode: Yes
Difficulties faced: No
"""
from collections import deque
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int)
        xLevel = 0
        xParent = None
        yLevel = 0
        yParent = None
        level = 0
        if root is None or root.val == x or root.val == y:
            return False
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            for i in range(size):
                currentNode = queue.popleft()
                if currentNode.left:
                    if currentNode.left.val == x:
                        xLevel = level
                        xParent = currentNode
                    if currentNode.left.val == y:
                        yLevel = level
                        yParent = currentNode
                    queue.append(currentNode.left)
                if currentNode.right:
                    if currentNode.right.val == x:
                        xLevel = level
                        xParent = currentNode
                    if currentNode.right.val == y:
                        yLevel = level
                        yParent = currentNode
                    queue.append(currentNode.right)
            level+= 1
         
        return xParent != yParent and xLevel == yLevel