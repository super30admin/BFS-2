# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        finalresult =[]
        def rightsideviewhelperright(root,level):
            if not root:
                return
            if (level ==len(finalresult)):
                finalresult.append(root.val)

            rightsideviewhelperright(root.right,level+1)
            rightsideviewhelperright(root.left,level+1) 

        rightsideviewhelper(root,0)
        return finalresult
        """
        finalresult =[]
        def rightsideviewhelperleft(root,level):
            if not root:
                return None
            if (level == len(finalresult)):
                finalresult.append(root.val)
            elif(level<len(finalresult)):
                finalresult[level]=root.val
            
            rightsideviewhelperleft(root.left,level+1)
            rightsideviewhelperleft(root.right,level+1)
        
        rightsideviewhelperleft(root,0)
        return  finalresult

        