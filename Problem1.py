# LEETCODE PROBLEM : 199. BINARY TREE RIGHT SIDE VIEW
# TIME COMPLEXITY: O(N) where N denotes the number of nodes if it is an entire right sided tree
# SPACE COMPLEXITY: O(H) where H is the height we get for the right side of the tree that we have


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        if not root:
            return result
        def traversal(root,result,level):
            if root is None:
                return
            if len(result)==level:
                result.append(root.val)
            
            traversal(root.right,result,level+1)
            traversal(root.left,result,level+1)
        
        traversal(root,result,0)
        return result