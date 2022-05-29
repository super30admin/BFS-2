'''
// Time Complexity : 0(n) -- end up traversing all the nodes
// Space Complexity : 0(n/2) -- at max i.e. leaf nodes count 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
'''
'''
Another solution is to "check the babies" when we deque the "parent" from the queue.
If babies are equal to 'x' and 'y', in that case the parent will be same, I will return false.

For other cases, I will return True
'''

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        # initialize parents of x and y
        x_parent = None
        y_parent = None
        
        # Initialize lvl
        lvl = 0
        
        # Initialize queue
        queue = deque([])
        
        # enque root and parent
        queue.append((root,None))
        
        # iterate the queue
        while len(queue) != 0:
            
            # Initialize size
            size = len(queue)
            
            # iterate till count == size
            for count in range(0,size):
                
                # check if parents are not none
                if x_parent != None and y_parent != None:
                    # found my parents, so exit
                    break
                
                # deque from queue
                ele = queue.popleft()
                
                # check if my node is None
                if ele[0] == None:
                    continue
                
                # check if we have a match with 'x' or 'y'
                if ele[0].val == x:
                    x_parent = ele[1]
                    continue
                
                if ele[0].val == y:
                    y_parent = ele[1]
                    continue
                
                # enque to the queue only if x_parent and y_parent are both None
                if x_parent == None and y_parent == None:
                    
                    # check for leaf node
                    if ele[0].left == None and ele[0].right == None:
                        continue
                    
                    queue.append((ele[0].left,ele[0]))
                    queue.append((ele[0].right,ele[0]))
                
            
            # check conditions before moving to next level
            if (x_parent != None and y_parent == None) or (x_parent == None and y_parent != None):
                return False
            
            elif (x_parent != None and y_parent != None):
                
                if x_parent != y_parent:
                    return True
                
                else:
                    return False    
            else:
                lvl += 1
        
        # coming out of while loop
        lvl -= 1
        
        