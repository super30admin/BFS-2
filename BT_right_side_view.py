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
        :SC:O(n)
        :TC:O(n)
        """
        from collections import deque
        
        queue = deque()
        queue.append(root)
        result=[]
        
        # BFS
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                # take last value from each level
                if i==(size-1):
                    result.append(curr.val)
                
                if curr.left: queue.append(curr.left)
                if curr.right: queue.append(curr.right)    
            
        return result 
        