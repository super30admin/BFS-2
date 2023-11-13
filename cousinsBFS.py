# Time Complexity: O(n)
# Space Complexity: O(n) where N is the number of nodes in the Tree



from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.q = deque()
        self.q.append(root)

        while (len(self.q) > 0):
            size = len(self.q)
            x_flag = False
            y_flag = False

            for i in range(size):
                curr = self.q.popleft()

                if(curr.val == x):
                    x_flag = True
                
                if(curr.val == y):
                    y_flag = True
                
                if(curr.left and curr.right):
                    if((curr.left.val == x and curr.right.val == y) or (curr.left.val == y and curr.right.val == x)):
                        return False
                
                if(curr.left):
                    self.q.append(curr.left)
                
                if(curr.right):
                    self.q.append(curr.right)
            
        
            if(x_flag and y_flag):
                return True
            
            if(x_flag or y_flag):
                return False
