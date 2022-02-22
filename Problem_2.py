# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Followed this from class

from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        q = deque([ ])
        q.append(root)  
        foundOne = False
        while q:
            size = len(q)
            for _ in range(size):
                curr  = q.popleft()
                if curr.val == x or curr.val == y: 
                    if foundOne: 
                        return True 
                    else:
                        foundOne = True 
                
                if curr.left and curr.right: 
                    leftVal = curr.left.val
                    rightVal = curr.right.val
                    if leftVal == x and rightVal == y:
                        return False
                    if leftVal == y and rightVal == x:
                        return False
                
                if curr.left: 
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            
            if foundOne: 
                return False