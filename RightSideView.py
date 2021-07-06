# Time : O(N)
# Space: O(H)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        if root is None:
            return result
        self.dfs(root ,0 ,result)
        return result


    def dfs(self ,node, level ,result):
        # base case
        if node is None:
            return
            # logic
        if level == len(result):
            result.append(node.val)

        self.dfs(node.right ,level +1 ,result)
        self.dfs(node.left ,level +1 ,result)

        # BFS solution
#         q = deque()
#         q.append(root)
#         result = []

#         if root is None:
#             return result

#         while q:
#             #maintain nodes in each level
#             size = len(q)
#             #traverse thru the level
#             for i in range(size):
#                 # Take element out from the level
#                 curr = q.popleft()
#                 #take the rightmost i.e last of the two at each level
#                   and add to result
#                 if i == size-1:
#                     result.append(curr.val)
#                 if curr.left: q.append(curr.left)
#                 if curr.right: q.append(curr.right)
#         return result
