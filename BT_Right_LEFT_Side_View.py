# Time complexity: O(N)
# Space complexity: O(D) to keep the queues, where D is a tree diameter
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # Base case
        if not root:
            return []
        
        # Using deque since adding or removing at end or front is O(1)
        queue = deque()
        queue.append(root)
        result = []
        
        # Check till queue not empty
        while queue:
            # Get the length
            queue_len = len(queue) 
            for i in range(queue_len):
                #print(i,queue_len)
                node = queue.popleft()
                
                # for RIGHT side view use queue_len -1 and for LEFT side view use i==0
                if i == queue_len - 1:
                    result.append(node.val)
                
                # Check node.left not None and add to queue
                if node.left != None:
                    queue.append(node.left)
                    
                # Check node.right not None and add to queue    
                if node.right != None:
                    queue.append(node.right)
        
        # Return the result 
        return result
