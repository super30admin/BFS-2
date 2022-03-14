// Time Complexity : O(n) 
// Space Complexity : O(maximum number of elements in a level) # result list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
1. Traverse one level at a time.
2. We need a queque,size variable and variables to check
   x,y don't belong to same parent
3. As we start with root in queue, size intitially will be 1
4. If size is greater than zero, process(pop) the node and add 
   its children if children values of a node not equal to x,y. 
   Decrease the size by 1
5. when size is zero, the level's values are in list. 
   check in x,y present. return true in present else move to next level
6. Return False.
   
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        if root is None:
            return False
        
        queue=[]
        queue.append(root)
        size=1
        tr=[]
        
        while len(queue) != 0:
            node=queue.pop(0)
            if node:
                try:
                    lc_val = node.left.val
                except:
                    lc_val = -1
                try:
                    rc_val = node.right.val
                except:
                    rc_val = -1

                if (lc_val==x and rc_val==y) or (lc_val==y and rc_val==x):
                    return False
                tr.append(node.val)
                queue.append(node.left)
                queue.append(node.right)
            size=size-1
            
            if size==0:
                if x in tr and y in tr:
                    return True
                tr=[]
                size=len(queue) 
              
        return False
                
        