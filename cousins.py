# Definition for a binary tree node.
from collections import deque
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        que = deque([root])
        pque = deque([None])

        while root != None:
            x_found = False
            y_found = False
            x_parent = None
            y_parent = None

            size = len(que)

            for i in range(size):
                curr = que.popleft()
                pcurr = pque.popleft()

                if curr.val == x:
                    x_found = True
                    x_parent = pcurr
                if curr.val == y:
                    y_found = True
                    y_parent = pcurr
                if curr.left !=None:
                    que.append(curr.left)
                    pque.append(curr)
                if curr.right !=None:
                    que.append(curr.right)
                    pque.append(curr)
            if (x_found and y_found):
                return (x_parent != y_parent)
            if (x_found or y_found):
                return False
        return False


        
        