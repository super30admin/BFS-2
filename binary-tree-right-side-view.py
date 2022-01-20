# Time Complexity: O(n)
# Space Complexity: O(h)
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
        # DFS
        result = []
        if not root: return result
        def dfs(root, level):
            # Base
            if not root: return
            # Logic
            if len(result) == level:
                result.append(root.val)
            dfs(root.right, level+1)
            dfs(root.left, level+1)
        dfs(root, 0)
        return result
        
        # BFS
        # result = []
        # if not root: return result
        # queue = []
        # queue.append(root)
        # while queue:
        #     size = len(queue)
        #     for i in range(size):
        #         curr = queue.pop(0)
        #         if i == size-1:
        #             result.append(curr.val)
        #         if curr.left: queue.append(curr.left)
        #         if curr.right: queue.append(curr.right)
        # return result