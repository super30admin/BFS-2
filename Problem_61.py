# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        ######### BFS Approach O(n) time and O(n) space n/2 will be size of queue at leaf nodes ##########
#         if not root:
#             return
#         result = collections.deque()
#         q = collections.deque() # Queue
        
#         q.appendleft(root)
        
#         while q:
#             size = len(q)
#             for i in range(size):
#                 curr = q.pop()
#                 if i == size-1:
#                     # If i==0 gives us left side view
#                     result.append(curr.val)
#                 if curr.left:
#                     q.appendleft(curr.left)
#                 if curr.right:
#                     q.appendleft(curr.right)
        
#         return result

        ##################### DFS Approach  O(n) time and O(h) space  #################
        if not root:
            return
        result = collections.deque()
        
        def dfs(root,depth,result):
            if not root:
                return
            if depth == len(result):
                result.append(root.val)
            dfs(root.right,depth+1,result)
            dfs(root.left,depth+1,result)
            
        dfs(root,0,result)        
        return result
    