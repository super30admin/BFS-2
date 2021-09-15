# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC O(n)
# SC O(n)
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        result = [] # to store integer
        queue = deque([]) # to store TreeNode
        queue.append(root)
        while len(queue) > 0:
            size = len(queue)
            for i in range(size):
                cur = queue.popleft()
                
                # Add last element from the all the nodes present at a level
                if i == size - 1:
                    result.append(cur.val)
                if cur.left is not None:
                    queue.append(cur.left)
                if cur.right is not None:
                    queue.append(cur.right)
        return result
        
                    
            
        
