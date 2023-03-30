# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # DFS APPROACH
        # if root.val == x or root.val == y:
        #     return False
        # global parentX, parentY, flag, levelX, levelY
        # parentX = parentY = None
        # flag = True
        # def dfs(root, parent, lvl):
        #     global parentX, parentY, flag, levelX, levelY
        #     if not root: return
        #     if not flag: return
        #     if root.val == x:
        #         parentX = parent.val
        #         levelX = lvl
        #     if root.val == y:
        #         parentY = parent.val
        #         levelY = lvl
        #     if parentX and parentY:
        #         if parentX == parentY or levelX != levelY:
        #             flag = False
        #             return
        #     dfs(root.left, root, lvl+1)
        #     dfs(root.right, root, lvl+1)


        # dfs(root, None, 0)
        # return flag

        # BFS APPROACH
        temp = []
        dq = collections.deque()
        prv_lvl = lvl = 0
        parent = None
        dq.append((root, parent, lvl))
        x_flag = y_flag = False
        parentX = parentY = None

        while dq:
            curr, parent, lvl = dq.popleft()
            if prv_lvl != lvl:
                if x_flag and y_flag:
                    if parentX != parentY:
                        return True
                    return False
                if x_flag or y_flag:
                    return False
                temp = []
                prv_lvl = lvl
            temp.append(curr)

            if curr.val == x:
                x_flag = True
                parentX = parent
            if curr.val == y:
                y_flag = True
                parentY = parent

            if curr.left:
                dq.append((curr.left, curr, lvl+1))
            if curr.right:
                dq.append((curr.right, curr, lvl+1))
        if x_flag and y_flag:
            if parentX != parentY:
                return True
            return False
        if x_flag or y_flag:
            return False


