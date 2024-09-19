# Time complexity - O(n)
# Space complexity - O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Time complexity - O(n)
# Time complexity - O(n)
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        res = []
        level = 0
        
        def helper(root, level):
            if not root: return

            if level == len(res):
                res.append(root.val)
            
            helper(root.right, level+1)
            helper(root.left, level+1)
        helper(root, level)
        return res


# iterative solution

        # queue = deque([root])
        # result = []
        # while queue:
        #     size = len(queue)
        #     for i in range(size):
        #         node = queue.popleft()
        #         if i == size - 1:
        #             result.append(node.val)
        #         node.left and queue.append(node.left)
        #         node.right and queue.append(node.right)
        # return result












                
