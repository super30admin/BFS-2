# // Time Complexity : O(n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# Level order traverser the tree and put the right most values at every level

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        res = []
        if root == None:
            return None
        Queue = deque()
        Queue.append(root)
        depth = 0
        while Queue:
            size = len(Queue)
            for i in range(size):
                CurrNode = Queue.popleft()
                if i == size -1:
                    res.append(CurrNode.val)
                    
                if CurrNode.left != None: 
                    Queue.append(CurrNode.left)
                if CurrNode.right != None: 
                    Queue.append(CurrNode.right)
        return res
                
        