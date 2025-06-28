# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        res = []

        queue = deque()

        if root:
            queue.append(root)

        while queue:
            size = len(queue)
            arr = []
            while size > 0:
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                arr.append(node.val)
                size -= 1
            if len(arr) > 0:
                res.append(arr[-1])

        return res


# Approach DFS with right recursive call 
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        def dfs(node, level):
            if not node:
                return

            if len(res) == level:
                res.append(node.val)

            dfs(node.right, level+1)
            dfs(node.left, level+1)

        dfs(root,0)

        return res



# Approach DFS with left recursive call 