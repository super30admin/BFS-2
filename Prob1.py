# Time Complexity : O(n)
# Space Complexity : O(H)
# The code ran on LeetCode
# In Method1-BFS, we do level order traversal from left to right, append elemnt to list when we are at the n-1th element at current level.
# In Method2-DFS, we go right first and whenever we go to a new level, add it to the list
# In Method3-DFS, we go left first and whenever we go to a new level, add it to the list. And later we overwrite them, we level<size of res, essentially when you go over right side of the tree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # Method 1 - BFS 
        # if not root: return []
        # q=deque()
        # res=[]
        # q.append(root)

        # while q:
        #     size=len(q)
        #     for i in range(size):
        #         curr=q.popleft()
        #         if i==size-1:
        #             res.append(curr.val)
        #         if curr.left:
        #             q.append(curr.left)
        #         if curr.right:
        #             q.append(curr.right)
        # return res

        # Method 2 - DFS going right first
        # res=[]
        # def dfs(root,level,res):
        #     if not root: return

        #     if len(res)==level: #because we go right first, we can directly add current value the moment we visit a new level for the first time
        #         res.append(root.val)
            
        #     dfs(root.right,level+1,res)
        #     dfs(root.left,level+1,res)
        # dfs(root,0,res)
        # return res
        
        # Method 3 - DFS going left first
        res=[]

        def dfs(root,level,res):
            if not root: return

            if len(res)==level:
                res.append(root.val)
            else:                       #we are overwriting the values from right side iteration
                res[level]=root.val
            dfs(root.left,level+1,res)
            dfs(root.right,level+1,res)
        dfs(root,0,res)
        return res
