#  Time Complexity : O(n) where n is the number of nodes.
#  Space Complexity : O(n) where n is the number of nodes.
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : Yes.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root == None: 
            return result
        queue = deque()
        queue.append(root)
        while(len(queue)!= 0):
            size = len(queue)
            result.append(queue[size-1].val)
            for i in range(size):
                # node = queue.pop(0) # O(n)
                node = queue.popleft() # O(1)
                if node.left != None:   
                    queue.append(node.left)
                if node.right != None:   
                    queue.append(node.right)
        return result
