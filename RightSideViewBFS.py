# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    '''Time Complexity: O(n)
    Space Complexity: O(n)'''
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #BFS
        if not root:
            return None
        
        result=[]
        #insert root in the queue
        queue=deque([root])
        while len(queue)!=0:
            size=len(queue)
            for i in range(size):
                curr_node=queue.popleft()
                #If the current index and the size of the queue are equal then add
                if i ==size-1:
                    result.append(curr_node.val)
                if curr_node.left is not None:
                    queue.append(curr_node.left)
                if curr_node.right is not None:
                    queue.append(curr_node.right)
        return result
        
