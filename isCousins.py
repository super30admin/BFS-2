# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nope


# Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        
        queue = deque([root])
        
        while queue:
            size = len(queue)
            xFound = False
            yFound = False
            
            for i in range(size):
                curr = queue.popleft()
                if curr.val == x:
                    xFound = True
                if curr.val == y:
                    yFound = True
                    
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False 
                
                if curr.left:
                    queue.append(curr.left)
                if curr.right: 
                    queue.append(curr.right)
            
            if xFound and yFound:
                return True
            if xFound or yFound:
                return False
        return False
        