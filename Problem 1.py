# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        #recursive
        result = []
        def helper(root, depth):
            if not root:
                return
            
            nonlocal result
            if len(result) == depth:
                result.append(root.val)
                
            helper(root.right, depth + 1)
            helper(root.left, depth + 1)

        helper(root, 0)
        return result


        #iterative
        # if not root: return []
        # q = deque()
        # q.append(root)
        # res = []
        # while q:
        #     l = len(q)
        #     while l > 0:
        #         cur = q.popleft()
        #         if cur.left : q.append(cur.left)
        #         if cur.right : q.append(cur.right)
        #         l -= 1
        #     res.append(cur.val)
        # return res

