# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''Jaspinder Sir's solution. SO ELEGANT. I LOVE IT.'''

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
                if curr.val == x or curr.val == y: #if you found x or y
                    if foundOne: # if one has already been found return true
                        return True # we can do this because we are eliminating all failures
                    else:
                        foundOne = True # if this is first find then set flag
                
                if curr.left and curr.right: # if same parent terminate
                    leftVal = curr.left.val
                    rightVal = curr.right.val
                    if leftVal == x and rightVal == y:
                        return False
                    if leftVal == y and rightVal == x:
                        return False
                
                if curr.left: # continue BFS
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            
            if foundOne: # The next one will not be on same level
                return False