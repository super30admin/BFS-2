#recursive
#TIME COMPLEXITY -> O(N)
#SPACE COMPLEXITY -> O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.li = []
        self.helper(root,0)
 
        return self.li
    def helper(self,root,level):
        #first appending all right nodes and then left nodes if exist in right subtree
        if not root:
            return None
        if len(self.li) == level:
            self.li.append(root.val)
        
        if root.right:
            self.helper(root.right,level+1)
        if root.left:
            self.helper(root.left,level+1)
            
        
            
#ITERATIVE
#TIME COMPLEXITY -> O(N)
#SPACE COMPLEXITY -> O(N/2) = O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        if not root:
            return None
        queue = [root]
        li = []
        while queue:
            size = len(queue)
            for i in range(size):
                value = queue.pop(0)
                if value.left:
                    queue.append(value.left)
                if value.right:
                    queue.append(value.right)
            #appending last value in particular level     
            li.append(value.val)
            
        return li