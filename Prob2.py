#Time complexity for put and get: O(n)
#Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        if root is None:
            return False
        #BFS Implementation
        q = deque([root])
        while q:
            size = len(q)
            x_found,y_found = False,False
            for i in xrange(size):
                node = q.popleft()
                if node.val == x:
                    x_found = True
                if node.val == y:
                    y_found = True
                
                if node.left is not None:
                    q.append(node.left)
                if node.right is not None:
                    q.append(node.right)
                if node.left is not None and node.right is not None:
                    #if same parents then not cousins
                    if node.left.val == x and node.right.val == y:
                        return False
                    if node.left.val == y and node.right.val == x:
                        return False
                        #if both found at same level, return true
            if x_found and y_found:
                return True
                #if at diff levels, no point
            if x_found or y_found:
                return False
        return False
        #DFS Implementation
#         self.xDep,self.yDep = 0,0
#         self.xPar,self.yPar = None,None
#         self.xFlag,self.yFlag = False,False
#         def dfs(root,parent,depth,x,y):
#             #base
#             if root is None:
#                 return
#             #logic
#             if x == root.val:
#                 self.xDep = depth
#                 self.xPar = parent
#                 self.xFlag = True
#             if y == root.val:
#                 self.yDep = depth
#                 self.yPar = parent
#                 self.yFlag = True
            
#             dfs(root.left,root,depth+1,x,y)
#             if self.xFlag and self.yFlag:
#                 return
#             else:
#                 dfs(root.right,root,depth+1,x,y)
            
#         dfs(root,None,0,x,y)
#         return self.xPar != self.yPar and self.xDep == self.yDep
    