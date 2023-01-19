# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        st=[root]
        final=[]
        while st:
            l=[]
            w=[]
            for i in st:
                w.append(i.val)
                if i.left:
                    l.append(i.left)
                if i.right:
                    l.append(i.right)
            st=l
            final.append(w[-1])
        return(final)
                    

#         if not root:
#             return []
        
#         visited_depth = [0] 
#         res =  []
#         def helper(node, depth=0):
#             if node and visited_depth[0] <= depth:
#                 print(visited_depth[0], depth,"==",node.val)
#                 res.append(node.val)
#                 visited_depth[0]+=1

#             if node.right:
#                 helper(node.right, depth+1)
                
#             if node.left:
#                 helper(node.left, depth+1)
        
#         helper(root)
#         return res    