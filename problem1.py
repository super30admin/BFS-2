"""
for right side view, if the element in the queue is at the last position (elements in the queue represent all the nodes in the current level) so that last value would be something we
see from the right side. appenedd those elements to the list and rest go into the queue
TC for this problem would be o(n) since we have to go through all elements and SC for this would be o(n/2) for the queue so asymptotically it is o(N)

"""
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        if not root:
            return []
        queue = collections.deque([root])
        res = []
        
        while queue:
            length = len(queue)
            for x in range(length):
                node = queue.popleft()

                if x == length - 1:
                    res.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return res