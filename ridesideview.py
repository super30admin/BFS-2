# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        '''
        DFS based solution: 
        Time Complexity: O(n)
        Space Complexity: O(1)
        '''
        '''
        If we go on right side first we will not replace the element
        '''
        res = []
        
        def rideSideView(root,h):
            if(root==None):
                return
            nonlocal res            
            #if(h>=len(res)):
            #    res.append(root.val)
            #else:
            #    res[h] = root.val
            if(h>=len(res)):
                res.append(root.val)
            rideSideView(root.right,h+1)
            rideSideView(root.left,h+1)
            
        
        #rideSideView(root,0)
        #return res
        
        '''
        BFS based
        Time Complexity: O(n)
        Space Complexity: O(n)
        '''
        if(root==None):
            return []
        q = deque([root])
        o = []
        while(len(q)>0):
            s = len(q) 
            i=0 
            while(i<s):
                e = q.popleft() 
                if(e.left!=None): 
                    q.append(e.left) 
                if(e.right!=None):
                    q.append(e.right) 
                if(i==s-1): 
                    o.append(e.val) 
                i+=1
        return o
