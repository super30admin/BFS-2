'''
// Time Complexity : 0(n) -- end up traversing all the nodes
// Space Complexity : 0(n/2) -- at max i.e. leaf nodes count 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
'''
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        # base-check
        if root == None:
            return []
        
        # Initialize resultList
        resultList = []
        
        # Initialize lvl
        lvl = 0
        
        # Initialize queue
        queue = deque([])
        
        # enque root
        queue.append(root)
        
        # Iterate queue
        while len(queue) != 0:
            
            # initialize size of the queue
            size = len(queue)
            
            # Iterate till count == size
            for count in range(0,size):
                
                # chk in lvl index exist
                if len(resultList) == lvl:
                    resultList.append(None)
                
                # deque the ele
                ele = queue.popleft()
                
                # base-check
                if ele == None: 
                    continue
                
                # rhs-view only
                resultList[lvl] = ele.val
                
                # check for leaf node
                if ele.left == None and ele.right == None:
                    continue
                
                # enque left and right node
                queue.append(ele.left)
                queue.append(ele.right)
                
            # update my lvl
            lvl += 1
        
        # update the lvl
        lvl -= 1
        
        # return the resulList
        #print(resultList)
        return resultList
        