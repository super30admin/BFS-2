# Time Complexity: O(N)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Here we simply perform a BFS and output the last element of the queue at a particular level
class Solution:
        # BFS Approach
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root==None:
            return []
        queue = list()
        values = list()
        queue.append(root)

        while len(queue)!=0:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                if curr.left!=None:
                    queue.append(curr.left)
                if curr.right!=None:
                    queue.append(curr.right)
                if i==size-1:
                    values.append(curr.val)
        return values

# Here we perform a DFS so we also need to pass the level of level along with node
    # DFS Approach: Right first
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         values = list()
#         def dfs(root,level):
#             if root==None:
#                 return
#             if len(values)-1<level:
#                 values.append(root.val)
#             # else:
#             #     values[level] = root.val

#             dfs(root.right,level+1)
#             dfs(root.left,level+1)

#         dfs(root,0)
#         return values

    # DFS Approach
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         values = list()
#         def dfs(root,level):
#             if root==None:
#                 return
#             if len(values)-1<level:
#                 values.append(root.val)
#             else:
#                 values[level] = root.val

#             dfs(root.left,level+1)
#             dfs(root.right,level+1)

#         dfs(root,0)
#         return values