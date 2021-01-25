#Time Complexity :o(n)
#Space Complexity :o(m) m-maximum elements at any level
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #BFS
        result=[]
        if(root==None):
            return []  
        queue=collections.deque()
        queue.append(root)
        
        while(len(queue)>0):
            size=len(queue)
            result.append(queue[size-1].val)
            for i in range(len(queue)):
                curr=queue.popleft()
                if(curr.left!=None):
                    queue.append(curr.left)
                if(curr.right!=None):
                    queue.append(curr.right)
        return result
        
        
        
#         result=[]
#         if(root==None):
#             return []
    
#         self.dfs(root,0,result)
#         return result
    
#     def dfs(self,root,level,result):
#         #base
#         if(root==None):
#             return 
#         #logic
#         if(level==len(result)):
#             result.append(root.val)
        
        
#         self.dfs(root.right,level+1,result)
#         self.dfs(root.left,level+1,result)