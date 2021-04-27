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
        q=deque()
        q.append(root)      
        while q:
            x_found = False
            y_found = False
            size=len(q)
            for i in range(size):
                curr = q.popleft()
                if curr.val == x:
                    x_found = True
                if curr.val ==y:
                    y_found = True
                if(curr.left and curr.right):
                    if((curr.left.val ==x and curr.right.val ==y) or (curr.left.val ==y and curr.right.val ==x)):
                        return False           
                if(curr.left):
                    q.append(curr.left)
                if(curr.right):
                    q.append(curr.right)
            if(x_found and y_found):
                return True
            if(x_found or y_found):
                return False
        return False
            
        