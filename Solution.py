class Solution(object):
    def __init__(self):
        self.x_parent = None
        self.y_parent = None
        self.x_depth = -1
        self.y_depth = -2
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        time: O(n)
        space: O(h) for dfs, O(n) for bfs
        """
        def dfs(t, parent, depth):
            if not t:
                return False
            if t.val == x:
                self.x_parent = parent
                self.x_depth = depth
            if t.val == y:
                self.y_parent = parent
                self.y_depth = depth
            if self.x_parent != None and self.y_parent != None and self.x_parent != self.y_parent and self.x_depth == self.y_depth:
                return True
            return helper(t.left, t, depth+1) or helper(t.right, t, depth+1)

        def bfs():
            q = deque([root])
            while q:
                size = len(q)
                found = 0
                for _ in range(size):
                    cur = q.popleft()                 
                    if (cur.left and cur.right):
                        if (cur.left.val == x and cur.right.val == y):
                            return False
                        if (cur.left.val == y and cur.right.val == x):
                            return False
                    if cur.val == x or cur.val == y:
                        found += 1
                    if found == 2:
                        return True
                    if cur.left:
                        q.append(cur.left)
                    if cur.right:
                        q.append(cur.right)
                if found == 1:
                    return False
            return False
        # return dfs(root, None, 0)
        return bfs()
            
            
        return helper(root, None, 0)
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        time: O(n)
        space: O(n)
        """
        if not root:
            return []
        q = deque([root])
        ans = []
        while q:
            size = len(q)
            for i in range(size):
                cur = q.popleft()
                if i == size - 1:
                    ans.append(cur.val)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
        return ans

