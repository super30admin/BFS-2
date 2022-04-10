#RECURSIVE
#TIME COMPLEXITY -> O(N)
#SPACE COMPLEXITY -> O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.xheight = 0
        self.yheight = 0
        self.flag = True
        self.helper(root,0,x,y)
        return self.xheight==self.yheight and self.flag
    
    def helper(self,root,level,x,y):
        #base
        if not root:
            return None
        #check if both child belongs to same parent
        if root.left and root.right:
            if root.left.val == x and root.right.val == y:
                self.flag = False
            if root.left.val == y and root.right.val == x:
                self.flag = False
        
        #if found assigning them respective levels and check them later
        if root.val == x:
            self.xheight = level
        if root.val == y:
            self.yheight = level
    
        #root
        self.helper(root.left,level+1,x,y)
        self.helper(root.right,level+1,x,y)


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
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        queue = [root]
        xfound = False
        yfound = False
        
        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.pop(0)
                if node.val == x:
                    xfound = True
                if node.val == y:
                    yfound = True
                #check if both child belongs to same parent
                if node.left and node.right:
                    if node.left.val == x and node.right.val == y:
                        return False
                if node.left and node.right:
                    if node.left.val == y and node.right.val == x:
                        return False
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                
            if xfound==True and yfound==True:
                return True
            #if one of targets found in particular level but other not found return False
            elif xfound != yfound:
                return False
            
        return False
        
                
        