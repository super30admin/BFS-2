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

        if not root:
            return []
        q=collections.deque()
        res=[]
        q.append(root)
        while q:
            size = len(q)
            for i in range(size):
                curr=q.popleft()
                if i == size-1:
                    res.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return res
###################################################

        # if not root:
        #     return []
        # res=[]
        # def helper(root, level):
        #     if len(res) == level:
        #         res.append(root.val)
        #         print (res)
        #     if root.right:
        #         helper(root.right,level+1)
        #     if root.left:
        #         helper(root.left, level+1)
        # helper(root,0)
        # return res
