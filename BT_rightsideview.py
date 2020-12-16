# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #DFS
        #O(N)
        #O(h)
        if not root:
            return []
        self.ret = [ ]
        def helper( root, level):
            if root:
                if len(self.ret) == level:
                    #this happens for new rightnodeonly and thats added to answer
                    self.ret.append(root.val)
                #traversing right side first
                helper(root.right, level+1) 
                helper(root.left,  level+1) 
        helper(root, 0)
        return self.ret 
    
    
    
        #O(N)
        #O(N)
#        #same as BFS level order approach, here we dont need extra levels subarray
#         if not root:
#             return []
#         op=[]
#         q=deque()
#         q.append(root)
#         while q:
#             qsize=len(q)
#             while qsize:
#                 #gets replaced by upcoming value in queue everytime
#                 popped=q.popleft()
#                 if popped.left:
#                     q.append(popped.left)
#                 if popped.right:
#                     q.append(popped.right)
#                 qsize-=1
#             #here popped will be the last value of that level 
#             op.append(popped.val)
#         return op
            
            
                    
        
          