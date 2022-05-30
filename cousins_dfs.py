# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#APPROACH : DFS
#Time Complexity : O(n)
#Space Complexity : O(h) h-> height of tree
#Did your code run on leetcode: yes

class Solution:
    global x_depth,y_depth,x_parent,y_parent
    x_depth = 0
    y_depth = 0
    x_parent =  None
    y_parent = None
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        global x_depth,y_depth,x_parent,y_parent


        
        if root == None: return False
        
        self.dfs(root,x,y,0,None)
        return x_depth == y_depth and x_parent != y_parent
                
    def dfs(self, root: Optional[TreeNode], x: int, y: int,depth:int,parent :  Optional[TreeNode])->None:
        #base
        global x_depth,y_depth,x_parent,y_parent
        if(root == None) : return
        #logic
        if(root.val == x):
            x_depth = depth
            x_parent = parent
            
        if(root.val == y):
            y_depth = depth
            y_parent = parent
            
        self.dfs(root.left,x,y,depth+1,root)
        self.dfs(root.right,x,y,depth+1,root)


        
