#Time complexity for put and get: O(n)
#Space complexity: O(n)
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
        if root is None:
            return []
        #DFS
        self.res = []
        def helper(root,level):
            #base
            if root is None:
                return
            #logic
            if len(self.res) == level:
                self.res.append(root.val)
            helper(root.right,level+1)
            helper(root.left,level+1)
        helper(root,0)
        return self.res
        # BFS
        # q = deque([root])
        # res = []
        # while q:
        #     size = len(q)
        #     for i in xrange(size):
        #         node = q.popleft()
        #         if i == size-1:
        #             res.append(node.val)
        #         if node.left is not None:
        #             q.append(node.left)
        #         if node.right is not None:
        #             q.append(node.right)
        return res