# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        #        dfs
# time complexity is o(n), where n is the size of the input
# space complexity is o(h), h = log(n), where n is the size of the input, o(h) is Recursive stack space.
        l = list()
        self.dfs(root, 0, l)
        return l
    def dfs(self, root, level, l):
        if(root == None):
            return 
        if(len(l) == level):
            l.append(root.val)
        else:
            l[level] = root.val
        self.dfs(root.left, level + 1, l)
        self.dfs(root.right, level + 1, l)



#         bfs
# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
#         if(root == None):
#             return root
#         l = list()
#         from collections import deque
#         q = deque()
#         q.append(root)
#         while(len(q) != 0):
#             length = len(q)
#             for i in range(length):
#                 curr = q.popleft()
#                 if(i == length - 1):
#                     l.append(curr.val)
#                 if(curr.left != None):
#                     q.append(curr.left)
#                 if(curr.right != None):
#                     q.append(curr.right)
#         return l
                    
                
        
        
        

        
         