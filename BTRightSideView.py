# Time Complexity : O(N)  //Where n is the tree we are iterating
#  Space Complexity : O(N)  //We are using the queue to store the nodes
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        #Base case
        if not root:
            return []
        
        #Declare the result variable and a queue to append the nodes
        res =[]
        q = deque()
        q.append(root)
        
        #iterate over the queue to find the right side view
        while  q:
            size = len(q)
            #If the queue is not empty the pop the node and add it to queue, decrease the size
            while size != 0:
                node = q.popleft()
                if size == 1:
                    res.append(node.val)
                
                if node.left != None:
                    q.append(node.left)
                if node.right != None:
                    q.append(node.right)
                
                size -= 1
                
        return res
            