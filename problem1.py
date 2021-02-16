// Time Complexity : O(n)
// Space Complexity : O(max breadth at any level)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        output=[]
        if not root:    //if not root return empty list
            return output

        queue=deque()
        queue.append(root)
        
        while len(queue)>0:   
            size=len(queue)   //compute size of queue
            
            while size>0: //pop each node  and push left and right nodes if exist
                size-=1
                front= queue.popleft()
                if front.left:
                    queue.append(front.left)
                if front.right:
                    queue.append(front.right)
            output.append(front.val)    //everytime we finish the current while loop front is pointing to the right most element at each level hence append it in the output list
        return output
