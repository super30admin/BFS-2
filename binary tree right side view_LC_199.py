# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # bfs
    # def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
    #     if not root:
    #         return []
    #     que = [root]
    #     result = []
    #     while que:
    #         size = len(que)
    #         for i in range(size):
    #             curr = que.pop(0)
    #             if i == size - 1:
    #                 result.append(curr.val)
    #             if curr.left:
    #                 que.append(curr.left)
    #             if curr.right:
    #                 que.append(curr.right)

    #     return result

    # dfs right recursion first
    # def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
    #     self.result = []
    #     self.recurse(root, 0)
    #     return self.result
 
    # def recurse(self, root, lvl):
    #     #base case
    #     if not root:
    #         return

    #     #logic

    #     if lvl == len(self.result):
    #         self.result.append(root.val)
    #     self.recurse(root.right, lvl + 1)
    #     self.recurse(root.left, lvl + 1)

    # dfs left recursion first 
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.recurse(root, 0)
        return self.result
 
    def recurse(self, root, lvl):
        #base case
        if not root:
            return

        #logic

        if lvl == len(self.result):
            self.result.append(root.val)
        else:
            self.result[lvl] = root.val

        self.recurse(root.left, lvl + 1)
        self.recurse(root.right, lvl + 1)

