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
        # Time: O(N)
        # Space: O(H) // when dfs 
        #        O(N)// when BFS
        self.res = []
        if not root: return self.res

        def bfs(root):
            stk = collections.deque([root])
            while stk:
                n = len(stk)

                for i in range(n):
                    node = stk.popleft()
                    if i == n - 1:
                        self.res.append(node.val)
                    if node.left:
                        stk.append(node.left)
                    if node.right:
                        stk.append(node.right)

        def dfs(root, depth):
            if not root: return
            if len(self.res) == depth:
                self.res.append(root.val)
            else:
                self.res[depth] = root.val
            dfs(root.left, depth + 1)
            dfs(root.right, depth + 1)

        dfs(root, 0)
        return self.res
