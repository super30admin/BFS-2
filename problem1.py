# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

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
        
        q = deque()
        q.append(root)
        while len(q) != 0:
            size = len(q)
            x_flag = False
            y_flag = False
            
            for _ in range(size):
                curr = q.popleft()
                
                if curr.right is not None and curr.left is not None:
                    if x == curr.right.val and y == curr.left.val:
                        return False
                    if y == curr.right.val and x == curr.left.val:
                        return False
                    
                if curr.val == x:
                    x_flag = True
                elif curr.val == y:
                    y_flag = True
                    
                if curr.right is not None:
                    q.append(curr.right)
                if curr.left is not None:
                    q.append(curr.left)
                    
            if x_flag and y_flag:
                return True
            
        return False