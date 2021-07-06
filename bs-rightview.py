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
        if root == None:
            return []
        arr = []
        # towards left
        # def dfs(root,level):
        #     if root==None:
        #         return
        #     if len(arr)==level:
        #         arr.append(root.val)
        #     else:
        #         arr[level]=root.val
        #     dfs(root.left,level+1)
        #     dfs(root.right,level+1)
        # dfs(root,0)
        # return arr
        # towards right
        #         def dfs(root,level):
        #             if root==None:
        #                 return
        #             if len(arr)==level:
        #                 arr.append(root.val)
        #             dfs(root.right,level+1)
        #             dfs(root.left,level+1)

        #         dfs(root,0)
        #         return arr
        # time-o(n) space-o(h)
        # bfs
        from collections import deque
        q = deque()
        q.append(root)
        lis = [root.val]
        while q:
            length = len(q)
            for i in range(length):
                popp = q.popleft()
                if popp.left != None:
                    q.append(popp.left)
                if popp.right != None:
                    q.append(popp.right)

            if q:
                lis.append(q[-1].val)
            # print(lis)
        return lis
    # time=o(n) space-o(n/2)