# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # DFS APPRAOCH
        # global ans
        # ans = []
        # def dfs(root, lvl):
        #     global ans
        #     if not root: return
        #     if len(ans) == lvl:
        #         ans.append(root.val)
        #     ans[lvl] = root.val
        #     print(ans)
        #     dfs(root.left, lvl+1)
        #     dfs(root.right, lvl+1)

        # dfs(root, 0)
        # return ans

        # BFS APPROACH
        if not root:
            return
        ans = []
        dq = collections.deque()
        prv_lvl = lvl = 0
        dq.append((root, lvl))
        temp = []

        while dq:
            curr, lvl = dq.popleft()
            if prv_lvl != lvl:
                ans.append(temp[-1])
                temp = []
                prv_lvl = lvl
            temp.append(curr.val)

            if curr.left:
                dq.append((curr.left, lvl + 1))
            if curr.right:
                dq.append((curr.right, lvl + 1))
        ans.append(temp[-1])
        return ans

