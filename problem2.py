"""
We check the parents and the nodes both as a tuple and the perform BFS on it, we then checkk if both values (X and Y) donot have the same parents and return True
We establish this by pushing and storing both the parent and the node in the q
TC is O(N) and SC is O(N/2) asymptotically O(N) for the largest level we can find"""
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        if not root:
            return False
        q = deque([(root, None)]) #store both node and its parent, none for the root

        while q:
            xParent = yParent = None
            lenght = len(q)

            for _ in range(lenght):
                node, parent = q.popleft() #pop the tuple

                if node.val == x: #mark and remember the parent if its x or y
                    xParent = parent
                if node.val == y:
                    yParent = parent

                if node.left: #append other elements to the queu
                    q.append((node.left, node))
                if node.right:
                    q.append((node.right, node))
            #after one level is processed check parent conditions
            if xParent and yParent: #if they are on same level
                return xParent != yParent #return if they are not same
            if xParent or yParent: #only one found
                return False
 
        