# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        #1)different parents
        #2)same level
        
        
        #O(N)
        #O(N)
#        #same as BFS level order approach, here we dont need extra levels subarray
        
        q=deque()
        q.append(root)
       
        # store (value>>parent) mapentry 
        while q:
            size=len(q)
            temp={}
            for i in range((size)):
                node=q.popleft()
                if node.left:
                    q.append(node.left)
                    temp[node.left.val]=node.val
                if node.right:
                    q.append(node.right)
                    temp[node.right.val]=node.val
            
            if x in temp and y in temp and temp[x]!=temp[y]:
                return True
        return False
        
#         # store (parent, depth) tuple      
# 		# dfs
#O(N)
#O(h)
#         res=[]
#         def dfs(node, parent, depth):
#             if not node:
#                 return
#             if node.val == x or node.val == y:
#                 res.append((parent, depth))
#             if len(res)==2:return
#             dfs(node.left, node, depth + 1)
#             dfs(node.right, node, depth + 1)
            
#         dfs(root, None, 0)

# 		# unpack two nodes found
#         node_x, node_y = res  
		
# 		# compare and decide whether two nodes are cousins
#         return node_x[0] != node_y[0] and node_x[1] == node_y[1]