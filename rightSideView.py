# Time Complexity :O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No


class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        def bfs(root, level):
            if root is None:
                return
            if level == len(res):
                res.append(root.val)
            bfs(root.right, level+1)
            bfs(root.left, level + 1)

        res = []
        bfs(root, 0)
        return res