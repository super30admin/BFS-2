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
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        queue=deque()
        queue.append((root,-1))   //create queue of tuple where first element is current node and 2nd element is value of parent
        
        while len(queue)>0:
            size=len(queue)
            parent_x=-1   //initialize parent of x 
            parent_y=-1   //initialize the parent of y
            #print(size)
            while size>0:
                size-=1
                front=queue.popleft()   //pop the node
                print(front[0].val)
                if front[0].val==x:   //if value of node matches to any of x or y update parent as parent of node which is stored as the 2nd element of node
                    parent_x=front[1]
                elif front[0].val==y:
                    parent_y=front[1]
                    
                if front[0].left:   //if current node has left node append it in queue
                    queue.append((front[0].left,front[0].val))
                if front[0].right:    //if current node has right node append it in queue
                    queue.append((front[0].right,front[0].val))
            
            if parent_x!=-1 or parent_y!=-1:    //after finishing each level check if either of the parent of x or y is updated then check if they both are updated and if both have different parent then return True else return false
                if parent_x!=parent_y and parent_x!=-1 and parent_y!=-1:
                    return True
                else:
                    return False
                
                
        return False  //it means that both x and y are not found in the binary tree hance return False
        
